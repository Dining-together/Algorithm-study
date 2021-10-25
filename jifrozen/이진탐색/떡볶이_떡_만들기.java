package 이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 떡볶이_떡_만들기 {
	public static int bs(int arr[], int target, int start, int end) {
		int result = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}
			if (sum >= target) {
				result = mid;
				start = mid + 1;
			} else
				end = mid - 1;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int result = bs(arr, m, 1, arr[n - 1]);
		System.out.print(result);
	}
}
