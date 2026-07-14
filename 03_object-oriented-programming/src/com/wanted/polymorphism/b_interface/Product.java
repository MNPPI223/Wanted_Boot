package com.wanted.polymorphism.b_interface;

public class Product implements InterfaceProduct {

    @Override
    public void methodA() {
        System.out.println("methodA 호출됨...");
    }
}
