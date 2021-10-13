import java.util.*;
import java.io.*;

public class 위에서_아래로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];// reverse 정렬에서는 기본 타입 사용
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
