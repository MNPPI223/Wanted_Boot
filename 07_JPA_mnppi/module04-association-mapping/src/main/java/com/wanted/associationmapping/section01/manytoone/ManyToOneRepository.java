package com.wanted.associationmapping.section01.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ManyToOneRepository {

    @PersistenceContext
    private EntityManager manager;


    public Menu find(int menuCode) {

        return manager.find(Menu.class, menuCode);
    }


    public void registMenu(Menu menu) {

        manager.persist(menu);
    }

    /* comment. JPQL */
    public String findCategoryName(int menuCode) {

        String jpql = "SELECT c.categoryName " +
                "FROM menu_and_category m " +
                "JOIN m.category c " +
                "WHERE m.menuCode = :menuCode"; // menuCode 부분은 ?

        return manager.createQuery(jpql, String.class)
                .setParameter("menuCode", menuCode) // 28번 줄의 menuCode 넣기
                .getSingleResult();
    }
}
