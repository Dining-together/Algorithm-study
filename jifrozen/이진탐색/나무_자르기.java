package 이진탐색;
import java.util.*;

public class 나무_자르기 {
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		int start=1;
		int end=arr[n-1];
		int result=0;
		while(start<=end){
			long sum=0;
			int mid=(start+end)/2;
			for(int i=0;i<n;i++){
				if(arr[i]>mid){
					sum+=arr[i]-mid;
				}
			}
			if(sum==m){
				result=mid;
				break;
			}else if(sum>m){
				result=mid;
				start=mid;
			}
			else end=mid;
		}

		System.out.print(result);


	}
}
