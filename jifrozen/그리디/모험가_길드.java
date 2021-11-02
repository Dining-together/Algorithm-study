package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int cnt = 0;
        int group = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if (arr[i] == cnt) {
                group += 1;
                cnt = 0;

            }
        }
        System.out.print(group);
    }
}