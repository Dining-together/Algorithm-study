package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int money = sc.nextInt();
        Integer[] changes = new Integer[n];
        for (int i = 0; i < n; i++) {
            changes[i] = sc.nextInt();
        }

        Arrays.sort(changes, Collections.reverseOrder());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (money == 0) {
                break;
            }
            if (money < changes[i])
                continue;
            answer += money / changes[i];
            money = money % changes[i];
        }
        System.out.print(answer);
    }
}