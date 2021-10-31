package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 0 , 1 ,양수, 음수
        int zero = 0;
        int one = 0;
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp == 0) {
                zero++;
            } else if (tmp == 1) {
                one++;
            } else if (tmp > 0) {
                plus.add(tmp);
            } else {
                minus.add(tmp);
            }
        }
        if (minus.size() % 2 == 1) {
            // -5 -3 -2인 경우 0이 있으면 -5*-3 + -2*0 -> 15 최적값
            if (zero > 0) {
                minus.add(0);
            } else {
                minus.add(1);
            }
        }

        if (plus.size() % 2 == 1) {
            plus.add(1);
        }
        Collections.sort(minus);
        Collections.sort(plus);
        Collections.reverse(plus);

        int answer = 0;

        for (int i = 0; i < minus.size(); i = i + 2) {
            answer += minus.get(i) * minus.get(i + 1);
        }
        for (int i = 0; i < plus.size(); i = i + 2) {
            answer += plus.get(i) * plus.get(i + 1);
        }
        System.out.print(answer + one);

    }
}