package jifrozen.그리디;

import java.util.*;

/*
성공 코드
*/

public class Solution {
    public int solution(int[] food_times, long k) {
        int len = food_times.length;
        List<Food> foods = new LinkedList<Food>();
        // time과 index 넣어줌
        for (int i = 0; i < len; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }
        // time정렬
        Collections.sort(foods);
        int pre = 0;
        int i = 0;
        for (Food f : foods) {
            // 한 접시의 시간
            long time = f.getTime() - pre;
            // 그 시간이 0이 아니면
            if (time != 0) {
                // 가장 작은 시간 * 총 접시의 개수
                long spend = time * len;
                // 빼줘야하는 값과 비교
                if (spend <= k) {
                    // 크면 그냥 빼줌
                    k -= spend;
                    pre = f.getTime();
                } else {
                    // 작으면 나눈 나머지 구해서
                    k = k % len;
                    // index 정렬
                    foods.subList(i, food_times.length).sort(new Comparator<Food>() {
                        @Override
                        public int compare(Food a, Food b) {
                            return Integer.compare(a.getIndex(), b.getIndex());
                        }
                    });
                    // 나머지값의 index 리턴
                    return foods.get(i + (int) k).getIndex();

                }
            }
            len--;
            i++;
        }
        return -1;
    }

}

class Food implements Comparable<Food> {
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }

}