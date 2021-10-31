import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 게임_개발 {
    public static int turn(int d) {
        if (d == 0) {
            return 3;
        }
        return d - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] visited = new int[n][m];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], 0);
        }
        visited[a][b] = 1;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int result = 1;
        int cnt = 0;
        while (true) {
            d = turn(d);
            int nx = a + dx[d];
            int ny = b + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            if (arr[nx][ny] == 0 && visited[nx][ny] == 0) {
                a = nx;
                b = ny;
                visited[a][b] = 1;
                result += 1;
                cnt = 0;
            } else {
                cnt += 1;
            }
            if (cnt == 4) {
                nx = a - dx[d];
                ny = b - dy[d];
                if (arr[nx][ny] == 1) {
                    break;
                } else {
                    a = nx;
                    b = ny;
                }
                cnt = 0;
            }
        }
        System.out.print(result);

    }

}
