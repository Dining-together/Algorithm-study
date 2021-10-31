package 이진탐색;
import java.util.*;
class 입국심사 {

	public long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);
		long start=0;
		long end=Long.MAX_VALUE;

		while(start<=end){
			long sum=0;
			long mid=(start+end)/2;
			for(int i=0;i<times.length;i++){
				sum+=mid/times[i];
				if(sum>=n) break;
			}
			if(sum>=n){
				answer=mid;
				end=mid-1;
			}else start=mid+1;
		}


		return answer;
	}
}