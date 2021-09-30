package jifrozen.그리디;

import java.util.*;

/*
파이썬으로 같은 로직을 작성하면 잘 작동하는데 뭐가 잘못된건지 모르겠다.
*/
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

class Solution {
    public int solution(int[] food_times, long k) {
        int len = food_times.length;
        ArrayList<Food> foods = new ArrayList<>();
        // time과 index 넣어줌
        for (int i = 0; i < len; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }
        // time정렬
        Collections.sort(foods);
        // 전 접시 시간 계산
        int pre = 0;
        for (int i = 0; i < len; i++) {
            // 한 접시의 시간
            int time = foods.get(i).getTime() - pre;
            // 그 시간이 0이 아니면
            if (time != 0) {
                // 가장 작은 시간 * 총 접시의 개수
                int spend = time * len;
                // 빼줘야하는 값과 비교
                if (spend <= k) {
                    // 크면 그냥 빼줌
                    k -= spend;
                    pre = foods.get(i).getTime();
                } else {
                    // 작으면 나눈 나머지 구해서
                    k = k % len;
                    // index 정렬
                    Collections.sort(foods, new Comparator<Food>() {
                        @Override
                        public int compare(Food a, Food b) {
                            return Integer.compare(a.getIndex(), b.getIndex());
                        }
                    });
                    // 나머지값의 index 리턴
                    return foods.get((int) (k)).getIndex();

                }
            }
            // 다 먹은 접시 치우기
            len -= 1;
            foods.remove(foods.get(i));
        }
        return -1;
    }

}