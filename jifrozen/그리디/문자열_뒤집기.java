package jifrozen.그리디;

import java.util.*;

public class Main {
    // 이런식으로 전역변수로 처리하면 더 편할듯
    // public static String str;
    // public static int count0 = 0; // 전부 0으로 바꾸는 경우
    // public static int count1 = 0; // 전부 1로 바꾸는 경우
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int one = 0;
        int zero = 0;

        char cur = str.charAt(0);
        // 첫 번째 원소에 대해서도 처리해줘야함
        if (cur == '1') {
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < str.length(); i++) {
            char cr = str.charAt(i);
            if (cur != cr) {
                if (cr == '1') {
                    zero++;
                } else {
                    one++;
                }
                cur = cr;
            }

        }
        System.out.print(Math.min(one, zero));
    }
}