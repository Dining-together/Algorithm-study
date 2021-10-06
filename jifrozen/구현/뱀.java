import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//시간에 맞춰 회전
class Node {
    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return this.direction;
    }
}

// x좌표 y좌표
class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class 뱀 {

    public static int n, k, l;
    public static ArrayList<Node> info = new ArrayList<>();
    public static int[][] arr = new int[101][101];

    public static int[] dx = { 0, 1, 0, -1 };// 동 남 서 북
    public static int[] dy = { 1, 0, -1, 0 };

    public static int turn(int d, char c) {
        // 왼쪽 회전이면 동(0) -> 북(3) -> 서 (2)-> 남 (1)
        if (c == 'L')
            d = (d == 0) ? 3 : d - 1;
        // 오른쪽 회전이면 동(0) -> 남(1) -> 서(2) -> 북(3)
        else
            d = (d + 1) % 4;
        return d;
    }

    public static int simulate() {
        // 처음 위치
        int x = 1;
        int y = 1;
        // 처음 위치 뱀 존재 -> 2
        arr[x][y] = 2;
        // 오른쪽 바라봄 (동)
        int direction = 0;
        // 시간
        int time = 0;
        // 회전 횟수 확인
        int index = 0;
        // 뱀 길이 담을 queue
        Queue<Position> q = new LinkedList<>();
        // 처음 위치 queue에 담음
        q.offer(new Position(x, y));

        while (true) {
            // 다음 위치
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 벽에 부딪히지 않고 뱀 몸에 닿지 않으면
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
                // 사과가 없으면
                if (arr[nx][ny] == 0) {
                    // 머리 이동
                    arr[nx][ny] = 2;
                    // 꼬리 칸 비워줌
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                    // 머리 칸 채워줌
                    q.offer(new Position(nx, ny));

                }
                // 사과 있으면
                if (arr[nx][ny] == 1) {
                    // 머리 이동
                    arr[nx][ny] = 2;
                    // 머리칸 채워줌
                    q.offer(new Position(nx, ny));
                    // 꼬리칸 이동 x
                }
                // 벽이나 뱀의 몸에 부닺히는 경우
            } else {
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;
            // index가 회전 횟수 작고 회전해야할 시간이라면
            if (index < l && time == info.get(index).getTime()) {
                // 회전
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            info.add(new Node(time, c));
        }
        System.out.print(simulate());
    }

}
