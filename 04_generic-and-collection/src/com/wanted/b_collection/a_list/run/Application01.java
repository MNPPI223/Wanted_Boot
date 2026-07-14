package com.wanted.b_collection.a_list.run;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Application01 {

    public static void main(String[] args) {

        /* comment. Collection Framework
            1. List
            - 순서 있는 데이터 집합으로 데이터의 중복을 허용한다.
            2. Set
            - 순서 없는 데이터의 집합으로 데이터의 중복을 허용하지 않는다.
            3. Map
            - 키와 값 한 쌍으로 이루어지는 데이터 집합이다.
            - key 는 Set 방식으로 관리가 되어 있기 때문에 중복이 허용되지 않는다.
         */

        /* comment.
            ArrayList 는 가장 많이 사용되는 컬렉션의 클래스이다.
            내부적으로 배열의 특징을 가지고 있으며, 배열의 특징이기 때문에
            인덱스를 이용해 각 공간의 값에 접근할 수 있다.
         */
        List list = new ArrayList();

        list.add("apple");
        list.add("apple");
        list.add(123);
        list.add(123.23);
        list.add(new Date());

        System.out.println("list = " + list);

        System.out.println("list 의 사이즈 : " + list.size());

        for(int i = 0; i < list.size(); i++) {
            // list 안에 있는 값 꺼내는 방법
            System.out.println(i + " : " + list.get(i));
        }

        // list 추가하기
        list.add(1, "banana");
        System.out.println("list = " + list);

        // list 삭제하기
        list.remove(2);
        System.out.println("list = " + list);

        System.out.println("================ 구분선 =================");
        // 제네릭 개념을 사용해서 String 값만 들어가는 List 생성
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("c");
        stringList.add("b");
        stringList.add("d");
        System.out.println("stringList = " + stringList);

        Collections.sort(stringList);
        System.out.println("stringList = " + stringList);



    }

}
