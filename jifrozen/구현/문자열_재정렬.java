import java.util.*;

public class 문자열_재정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<Character> ca = new ArrayList<>();
        int val = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                ca.add(c);
            } else {
                val += c - '0';
            }
        }

        Collections.sort(ca);

        StringBuilder sb = new StringBuilder();
        for (char c : ca) {
            sb.append(c);
        }
        System.out.print(sb.toString() + val);

    }

}
