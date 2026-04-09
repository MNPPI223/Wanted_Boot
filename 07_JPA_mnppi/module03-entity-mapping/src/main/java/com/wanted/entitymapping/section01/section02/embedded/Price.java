package com.wanted.entitymapping.section01.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class Price {

    @Column(name = "regular_price")
    private int regularPrice;

    @Column(name = "discount_rate")
    private double discountRate;

    @Column(name = "sell_price")
    private int sellPrice;

    // 생성자 생성
    public Price() {}

    public Price(int regularPrice, double discountRate) {
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
    }
}
