package com.wanted.entitymapping.section01.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/* comment.
    JDBC 프로젝트에서 DB 와 접근하는 객체는 DAO 라고 표현했다.
    Spring 환경에서는 JPA 를 사용할 때 DAO 계층을
    @Repository 로 표현한다.
    - mybatis 기술을 사용하게 되면 @Mapper 라고 표현한다.

    해당 인터페이스는 JpaRepository 를 상속받아
    영속성 컨텍스트가 Entity 클래스를 관리할 수 있도록 한다.
    (내부적으로 EntityManager 를 사용한다.)
 */
public interface MemberRepository extends JpaRepository<Member, Integer> {



}
