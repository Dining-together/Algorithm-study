package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // char에서 int 형변환을 위해 '0'을 빼줌 -> 아스키
        int result = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            // result 랑 str.charAt(i) 둘다 비교해야하는 이유
            // 00234일 경우 2일때 str.charAt(i)가 1을 넘더라고
            // result = 0+0 이기 떄문에
            // 0+0+2로 해야함
            if (result <= 1 || str.charAt(i) <= 1) {
                result += (str.charAt(i) - '0');
            } else {
                result = result * (str.charAt(i) - '0');
            }
        }
        System.out.print(result);
    }
}