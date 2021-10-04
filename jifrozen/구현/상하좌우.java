import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 상하좌우 {

    public static void main(String[] args) throws Exception {
        String[] dir = { "L", "R", "U", "D" };
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> direction = new ArrayList<>();
        while (st.hasMoreTokens()) {
            direction.add(st.nextToken());
        }

        int x = 0, y = 0;
        for (String c : direction) {
            for (int j = 0; j < dir.length; j++) {
                if (dir[j].equals(c) && 0 <= x + dx[j] && x + dx[j] < n && 0 <= y + dy[j] && y + dy[j] < n) {
                    x = x + dx[j];
                    y = y + dy[j];
                }
            }
        }

        System.out.print((x + 1) + " " + (y + 1));

    }

}
