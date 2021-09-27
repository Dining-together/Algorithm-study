package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        while (n >= m) {
            if (n / m > 0) {
                cnt += n % m;
                n = n / m;
                cnt += 1;
            }
        }
        if (n > 1) {
            cnt += n - 1;
        }
        System.out.print(cnt);
    }
}