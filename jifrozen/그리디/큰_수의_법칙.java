package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer = (m / (k + 1)) * ((arr[n - 1] * k) + arr[n - 2]) + (m % (k + 1) * arr[n - 1]);
        System.out.print(answer);
    }
}