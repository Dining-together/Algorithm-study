package 이진탐색;
import java.util.*;

public class k번째수 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int k=sc.nextInt();

		int start=1;
		int end=k;
		int result=0;

		while(start<=end){
			int mid=(end+start)/2;
			int cnt=0;
			for(int i=1;i<=n;i++){
				cnt+=Math.min(n,mid/i);
			}

			if(cnt>=k){
				result=mid;
				end=mid-1;
			}else{
				start=mid+1;
			}
		}

		System.out.print(result);

	}
}
