package 이진탐색;
import java.util.*;
import java.io.*;

public class 고정점_찾기 {
	public static int bs(int[] arr,int start,int end){
		if(start>end) return -1;
		int mid = (start + end) / 2;
		if (arr[mid] == mid)
			return mid;
		else if (arr[mid] < mid)
			return bs(arr, mid + 1, end);
		else
			return bs(arr, start, mid - 1);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int result=bs(arr,0,n);

		System.out.print(result);
	}
}
