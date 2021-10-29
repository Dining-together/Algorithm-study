package 이진탐색;
import java.util.*;

public class 기타_레슨 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] arr=new int[n];
		int end = 0;
		int start=0;
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
			end+=arr[i];
			start=start<arr[i]?arr[i]:start;
		}

		while(start<=end){
			int sum=0;
			int cnt=0;
			int mid=(start+end)/2;
			for(int i=0;i<n;i++){
				if(sum+arr[i]>mid){
					sum=0;
					cnt++;
				}
				sum+=arr[i];
			}
			if(sum!=0) cnt++;
			if(cnt>m){
				start=mid+1;
			}else{
				end=mid-1;
			}
		}

		System.out.print(start);


	}
}
