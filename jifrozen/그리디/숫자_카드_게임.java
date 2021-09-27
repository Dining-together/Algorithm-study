package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int min_value = 100001;
            for (int j = 0; j < m; j++) {
                int c = sc.nextInt();
                min_value = Math.min(min_value, c);
            }
            answer = Math.max(min_value, answer);
        }
        System.out.print(answer);
    }
}