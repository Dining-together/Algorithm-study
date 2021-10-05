import java.util.*;

public class 럭키_스트레이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int a = 0, b = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            a += str.charAt(i) - '0';
            b += str.charAt(str.length() - i - 1) - '0';
        }
        if (a == b) {
            System.out.print("LUCKY");

        } else {
            System.out.print("READY");
        }

    }

}
