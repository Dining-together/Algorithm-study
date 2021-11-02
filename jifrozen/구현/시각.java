import java.util.*;

public class 시각 {

    public static boolean check(int i, int j, int d) {
        if (i % 10 == 3 || j % 10 == 3 || j / 10 == 3 || d % 10 == 3 || d / 10 == 3) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int d = 0; d < 60; d++) {
                    if (check(i, j, d)) {
                        answer++;
                    }

                }
            }
        }
        System.out.print(answer);

    }
}
