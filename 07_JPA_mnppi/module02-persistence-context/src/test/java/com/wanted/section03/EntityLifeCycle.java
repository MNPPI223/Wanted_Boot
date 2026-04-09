package com.wanted.section03;

import com.wanted.section02.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityLifeCycle {

    private static EntityManagerFactory factory;
    private static EntityManager manager;

    @BeforeAll
    static void initFactory() {
        factory = Persistence.createEntityManagerFactory("jpatest");
    }

    // 요청 한번 당 하나씩 제작하기 위해 @BeforeEach 사용
    @BeforeEach
    void initManager() {
        manager = factory.createEntityManager();
    }

    @AfterEach
    void closeManager() {
        manager.close();
    }

    @AfterAll
    static void closeFactroy() {
        factory.close();
    }

    @Test
    // 한글로 DisplayMenu 대체 가능
    void 비영속_테스트_메서드() {

        /* comment
            객체를 생성하면(new), 영속성 컨텍스트와는 전혀 관련 없는 비영속 상태이다.
            new 연산자를 통해 자바 메모리(Heap)에만 존재하는 객체 상태
         */

        // given
        Menu foundMenu = manager.find(Menu.class,1);
        Menu newMenu = new Menu();

        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setCategoryCode(foundMenu.getCategoryCode());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());
        // 자료형 같고, 값도 똑같음.

        // when
        boolean isTrue = (foundMenu == newMenu);

        // then
        Assertions.assertFalse(isTrue);
    }


    @Test
        // 한글로 DisplayMenu 대체 가능
    void 영속성_테스트_메서드() {

        // 1차 캐싱 -> 최초에 조회를 하면, 기억한걸로 다시 실행 / 즉, find가 2번이지만 여기서는 1번만 동작

        // given
        Menu foundMenu = manager.find(Menu.class,1);
        Menu newMenu = manager.find(Menu.class, 1);

        // 자료형 같고, 값도 똑같음.

        // when
        boolean isTrue = (foundMenu == newMenu);

        // then
        Assertions.assertFalse(isTrue);
    }

    @Test
    void 준영속_detach_테스트() {

        // 데이터베이스에 저장된 적이 있어 식별자(ID)를 가지고 있지만, 더 이상 JPA의 관리 대상이 아니게 된 객체

        // given
        Menu foundMenu1 = manager.find(Menu.class, 11);
        Menu foundMenu2 = manager.find(Menu.class, 12);

        // when
        manager.detach(foundMenu2);
        foundMenu1.setMenuPrice(5000);
        foundMenu2.setMenuPrice(5000);

        // then
        assertEquals(5000, manager.find(Menu.class,11).getMenuPrice());
//        assertEquals(5000, manager.find(Menu.class,12).getMenuPrice());
    }

    @Test
    void 삭제_remove_테스트() {

        /* comment.
            remove() : 엔티티를 영속성 컨텍스트 및 DB 에서 삭제한다.
            단, 트랜젝션을 제어하지 않으면 영구적으로 반영되지 않는다.
         */

        Menu foundMenu = manager.find(Menu.class, 2);

        manager.remove(foundMenu);

        Menu refoundMenu = manager.find(Menu.class, 2);

        assertEquals(2, foundMenu.getMenuCode());
        assertEquals(null, refoundMenu);
    }

    @Test
    void 병합_merge_수정_테스트 () {
        Menu detachMenu = manager.find(Menu.class, 2);
        manager.detach(detachMenu);
        System.out.println("detachMenu.hashCode() = " + detachMenu.hashCode());
        
        detachMenu.setMenuName("짜장면");
        System.out.println("detachMenu.hashCode() = " + detachMenu.hashCode());
        Menu refoundMenu = manager.find(Menu.class, 2);
        detachMenu = manager.find(Menu.class, 2);

        System.out.println("detachMenu = " + detachMenu.hashCode());
        System.out.println("refoundMenu.hashCode() = " + refoundMenu.hashCode());

        manager.merge(detachMenu);

        Menu mergeMenu = manager.find(Menu.class,2);
        System.out.println("mergeMenu.hashCode() = " + mergeMenu.hashCode());
        assertEquals("짜장면",mergeMenu.getMenuName());
    }

}
