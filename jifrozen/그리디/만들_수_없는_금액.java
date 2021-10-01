package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int a = 1;
        // 누적합을 만들어준다.
        // 처음 값이 1보다 크면 최소값은 1이다.
        // 첫번째 값이 1이면 a=1 + 1 -> 2이다. 그 다음 값이 2보다 크면 최소값은 2이다.
        // 만약 a=5이면 이미 1,2,3,4는 만들어졌다는 전제이므로 5를 만들수있다.
        for (int i = 0; i < n; i++) {
            if (a < arr[i]) {
                break;
            }
            a += arr[i];
        }
        System.out.print(a);
    }

}
