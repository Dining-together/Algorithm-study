import java.util.*;

class Permutation {
    private int n;
    private int r;
    private int[] now;
    private ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}

class 외벽점검 {
    public int solution(int n, int[] weak, int[] dist) {
        ArrayList<Integer> weakList = new ArrayList<Integer>();
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i]);
        }
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i] + n);
        }
        int answer = dist.length + 1;
        Permutation perm = new Permutation(dist.length, dist.length);
        perm.permutation(dist, 0);
        ArrayList<ArrayList<Integer>> distList = perm.getResult();

        for (int start = 0; start < weak.length; start++) {
            for (int i = 0; i < distList.size(); i++) {
                int cnt = 1;
                int position = weakList.get(start) + distList.get(i).get(cnt - 1);
                for (int index = start; index < start + weak.length; index++) {
                    if (position < weakList.get(index)) {
                        cnt += 1;
                        if (cnt > dist.length) {
                            break;
                        }
                        position = weakList.get(index) + distList.get(i).get(cnt - 1);
                    }
                }
                answer = Math.min(answer, cnt);
            }
        }
        if (answer > dist.length) {
            return -1;
        }
        return answer;
    }
}