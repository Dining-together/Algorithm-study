package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] nums = str.split("-");
        ArrayList<Integer> plus = new ArrayList<>();

        for (String num : nums) {
            int sum = 0;
            // + 특문로 \\표시 필요
            String[] n = num.split("\\+");
            for (String i : n) {
                sum += Integer.parseInt(i);
            }
            plus.add(sum);
        }
        int result = plus.get(0);
        for (int i = 1; i < plus.size(); i++) {
            result = result - plus.get(i);
        }
        System.out.print(result);

    }
}