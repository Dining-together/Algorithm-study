package 이진탐색;
import java.util.*;
import java.io.*;
public class 정렬된_배열에서_특정_수의_개수_구하기 {
	public static int lowerBound(int[] arr,int target,int start, int end){
		while(start<end){
			int mid=(start+end)/2;
			if(arr[mid]>=target) end=mid;
			else start=mid+1;
		}
		return end;
	}

	public static int upperBound(int[] arr,int target,int start,int end){
		while(start<end){
			int mid=(start+end)/2;
			if(arr[mid]>target) end=mid;
			else start=mid+1;
		}
		return end;
	}


	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		 int[] arr=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		int right=upperBound(arr,x,0,n);
		int left=lowerBound(arr,x,0,n);

		int cnt=right-left;

		if(cnt==0) System.out.print(-1);
		else System.out.print(cnt);

	}
}
