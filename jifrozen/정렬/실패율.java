import java.util.*;

class Node implements Comparable<Node> {
    private int stage;
    private double fail;

    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return this.stage;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(other.fail, this.fail);
    }

}

class Solution {
    public int[] solution(int N, int[] stages) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        int len = stages.length;
        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    cnt += 1;
                }
            }
            double fail = 0;
            if (cnt >= 1) {
                fail = (double) cnt / len;
            }
            nodes.add(new Node(i, fail));
            len -= cnt;
        }

        Collections.sort(nodes);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = nodes.get(i).getStage();
        }

        return answer;
    }
}