package com.wanted.b_loop.chap01;

public class Application02 {

    public static void main(String[] args) {

        /* for 문 응용
           for 문을 활용해서 배열 처리나 합계 계산 같은 작업을 수행할 수 있다.

        *  */

        int goal = 100;
        int sum = 0;
        System.out.println("칼로리 목표 " + goal + " 입니다.");
        // 조건식 -> sum 값이 100을 초과하면 안된다.
        // 1회차를 반복할 때마다 10 씩 증가하게 할 것이다.
        // 초기값은 10으로 시작한다.

        for (int i = 10; sum <= goal;) {
            System.out.println("sum : " + sum);

            sum += i;
            // sum = sum + i;

            if (sum == 50) {
                System.out.println("회원님 이제 절반 왔습니다!");
            } else if (sum == 80){
                System.out.println("거의 다 왔어요");
            }
        }
    }
}
