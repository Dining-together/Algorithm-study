package 이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기_설치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int start = 1;
		int end = arr[n-1] - arr[0];
		int result = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			int value = arr[0];
			int cnt = 1;
			for (int i = 1; i < n; i++) {
				if (arr[i] >= value+mid) {
					value = arr[i];
					cnt += 1;
				}
			}
			if (cnt >= c) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid - 1;
			}
		}

		System.out.print(result);

	}
}
