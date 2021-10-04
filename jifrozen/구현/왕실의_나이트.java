import java.util.*;

public class 왕실의_나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int row = input.charAt(1) - '0';
        int col = input.charAt(0) - 'a' + 1;

        int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
        int x = row, y = col;
        int answer = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8)
                answer++;
        }
        System.out.print(answer);
    }

}
