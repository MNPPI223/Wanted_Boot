package com.wanted.docker.menu;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼 어노테이션에 아무것도 작성하지 않으면, 컬럼명이 그대로 노출된다.
    @Column
    private String name;

    @Column
    private Integer price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
