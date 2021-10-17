package 정렬;

import java.util.Arrays;

public class H_index {
	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int len = citations.length;
		for (int i = 0; i < len; i++) {
			if (citations[i] >= len - i) {
				answer = len - i;
				break;
			}
		}
		return answer;
	}
}
