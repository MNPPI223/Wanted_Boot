package com.wanted.b_collection.c_map;

import java.util.Properties;

public class Application02 {

    public static void main(String[] args) {

        /* comment. Properties 라는 것에 대해 알 수 있다.
            Properties 는 지금 당장은 사용하지 않지만,
            향후 Spring 모듈에서 계속 등장한다.
            설정 파일의 값을 읽어서 어플리케이션에 적용할 때
            사용된다. (ex -> .env, .properties, .yaml)
         */

        Properties properties = new Properties();
        properties.setProperty("driver", "cj.jdbc.driver.mysql");
        properties.setProperty("url", "jdbc:mysql:thin:@127.0.0.1:3306:xe");
        properties.setProperty("user", "wanted");
        properties.setProperty("password", "wanted");

        System.out.println("properties = " + properties);
    }

}
