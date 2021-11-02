import java.util.*;

public class Main {
    public static int solution(int n) {
        int[] changes = { 500, 100, 50, 10 };
        int answer = 0;
        for (int change : changes) {
            answer += n / change;
            n = n % change;
        }
        return answer;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(solution(n));
    }
}