import java.util.*;
import java.io.*;

public class 로봇_청소기 {
    public static int[] dx = { -1, 0, 1, 0 };// 북동남서
    public static int[] dy = { 0, 1, 0, -1 };

    public static int turn(int d) {
        if (d == 0) {
            return 3;
        } else {
            return d - 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[r][c] = 1;
        int result = 1;
        while (true) {
            boolean isCleaned = false;
            for (int i = 0; i < 4; i++) {
                d = turn(d);
                int nr = r + dx[d];
                int nc = c + dy[d];
                if (arr[nr][nc] == 0 && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    r = nr;
                    c = nc;
                    result += 1;
                    isCleaned = true;
                    break;
                }
            }
            if (!isCleaned) {
                int nr = r - dx[d];
                int nc = c - dy[d];
                if (arr[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                } else {
                    break;
                }
            }

        }
        System.out.print(result);
        br.close();

    }

}
