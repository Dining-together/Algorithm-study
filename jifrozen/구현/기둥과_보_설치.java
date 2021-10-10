import java.util.*;

/**
 * 런타임 에러
 */
class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int a;

    public Node(int x, int y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getA() {
        return this.a;
    }

    public String toString() {
        return "[" + this.x + " " + this.y + " " + this.a + "] ";
    }

    @Override
    public int compareTo(Node other) {
        if (this.x == other.x && this.y == other.y) {
            return Integer.compare(this.a, other.a);
        }
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}

class Solution {
    public static int[][] arr = new int[101][101];

    public static boolean possible(ArrayList<Node> answer) {
        for (int j = 0; j < answer.size(); j++) {

            int x = answer.get(j).getX();
            int y = answer.get(j).getY();
            int a = answer.get(j).getA();

            if (a == 0) {
                if (y == 0 || arr[x - 1][y] == 2 || arr[x][y - 1] == 1 || arr[x][y] == 2)
                    continue;
                else
                    return false;
            } else {
                if (arr[x][y - 1] == 1 || arr[x + 1][y - 1] == 1 || (arr[x - 1][y] == 2 && arr[x + 1][y] == 2))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<Node> answer = new ArrayList<Node>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (b == 0) {
                int index = 0;
                for (int in = 0; in < answer.size(); in++) {
                    if (x == answer.get(in).getX() && y == answer.get(in).getY() && a == answer.get(in).getA()) {
                        index = in;
                    }
                }
                answer.remove(index);
                arr[x][y] = 0;
                if (!possible(answer)) {
                    answer.add(new Node(x, y, a));
                    if (a == 0)
                        arr[x][y] = 1;// 기둥
                    else if (a == 1)
                        arr[x][y] = 2;// 보
                }
            } else {
                answer.add(new Node(x, y, a));
                if (a == 0)
                    arr[x][y] = 1;// 기둥
                else if (a == 1)
                    arr[x][y] = 2;// 보

                if (!possible(answer)) {
                    answer.remove(answer.size() - 1);
                    arr[x][y] = 0;
                }
            }
        }
        Collections.sort(answer);
        int[][] result = new int[answer.size()][3];
        for (int k = 0; k < answer.size(); k++) {
            result[k][0] = answer.get(k).getX();
            result[k][1] = answer.get(k).getY();
            result[k][2] = answer.get(k).getA();
        }
        return result;
    }
}