# Spring Cache 학습 정리

> 학습 목표: 캐시가 없을 때와 있을 때의 응답 속도 차이를 체감하고, Spring 캐시 어노테이션의 동작 방식을 이해한다.

---

## 1. 전체 흐름

```
클라이언트 요청
    ↓
ProductController  (/api/before 또는 /api/after)
    ↓
ProductService  (SlowSimulator로 의도적 지연 주입)
    ↓
ProductRepository  (MySQL 조회)
    ↓
응답 반환
```

- `before` : 캐시 없음 → 매 요청마다 DB까지 내려감
- `after` : 캐시 있음 → 두 번째 요청부터 DB 안 탐

---

## 2. 핵심 클래스 구조

**ProductController**
- `/api/before/products/{id}` → 상세 조회 (캐시 없음)
- `/api/before/products?keyword=&category=` → 검색 조회 (캐시 없음)
- `/api/after/...` → 실습 파트, 수강생이 직접 구현

**ProductService**
- `getProductBefore(id)` : 120ms 지연 후 DB 조회
- `searchBefore(keyword, category, minPrice, maxPrice)` : 450ms 지연 후 DB 조회
- `searchProducts()` : 빈 문자열은 null 변환 후 쿼리 실행

**ProductRepository**
- `JpaRepository` 상속
- `search()` : Native Query, name/category/price 범위 필터 + popularity 내림차순 30개 반환

**SlowSimulator**
- 캐시 효과를 눈에 보이게 만들기 위한 의도적 지연
- 상세 조회 120ms / 검색 조회 450ms

---

## 3. 캐시 설정 (LocalCacheConfig)

```java
@Configuration
@EnableCaching  // 이게 있어야 @Cacheable 등 어노테이션이 동작함
public class LocalCacheConfig {

    @Bean
    CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheNames(List.of("productDetail", "productSearch"));

        cacheManager.setCaffeine(
            Caffeine.newBuilder()
                .maximumSize(1_000)                        // 캐시 폭발 방지
                .expireAfterAccess(Duration.ofMinutes(5))  // 5분 미접근 시 만료 (TTL)
                .recordStats()                             // 히트율/미스율 통계 기록
                .removalListener(...)                      // 캐시 제거 시 로그 출력
        );

        return cacheManager;
    }
}
```

- 구현체: **Caffeine** (인메모리 캐시 라이브러리)
- CacheManager는 추상화 인터페이스 → 구현체만 바꾸면 Redis 등으로 교체 가능

---

## 4. 캐시 이름 & 키 설계

**CacheNames — 캐시 공간 이름**

| 상수 | 값 | 용도 |
|---|---|---|
| `PRODUCT_DETAIL` | `"productDetail"` | 상품 ID → 상세 1건 매핑 |
| `PRODUCT_SEARCH` | `"productSearch"` | 검색 조건 조합 → 결과 목록 매핑 |

**CacheKeys — 검색 캐시 키 생성 규칙**

```
keyword::category::minPrice::maxPrice

예) popular::digital::2000::12000
예) popular::*::*::*   (조건 없으면 * 로 대체)
```

조건이 하나라도 다르면 → 다른 캐시 키 → 캐시 미스 발생

---

## 5. 캐시 어노테이션 4종 (실습 파트 적용 예정)

| 어노테이션 | 동작 | 사용 시점 |
|---|---|---|
| `@Cacheable` | 캐시 있으면 반환, 없으면 실행 후 저장 | 조회 |
| `@CachePut` | 항상 실행, 결과로 캐시 갱신 | 강제 새로고침 |
| `@CacheEvict` | 캐시 항목 제거 | 삭제 |
| `@Caching` | 위 어노테이션 여러 개 동시 적용 | 갱신 + 무효화 동시 필요 시 |

> `@EnableCaching` 없으면 위 어노테이션 전부 무시됨. Spring이 프록시로 감싸야 동작하기 때문.

---

## 6. 성능 비교 방법 (k6 부하 테스트)

```bash
# 캐시 적용 전 기준선 측정
k6 run scripts/before.js

# 캐시 적용 후 성능 비교
k6 run scripts/after.js
```

- 가상 사용자 30명, 45초 동안 동일한 상품 ID (900~919) 반복 조회
- 같은 ID를 반복해야 캐시 적중률이 올라가서 효과가 눈에 보임
- 비교 지표: **p95 응답 시간** (before 목표 < 900ms / after는 훨씬 낮아야 함)

---

## 7. DB 구성

- DB: `menudb` / 유저: `wanted` / 비번: `wanted`
- 테이블: `products` (8,000건 더미 데이터)
- `ddl-auto: validate` → 앱이 테이블 직접 생성 안 하고 구조만 검증
- 인덱스: `category+popularity`, `price`, `updated_at` → 검색 쿼리 최적화용
