package 정렬;
import java.util.*;

public class 안테나 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);
		int len=arr.length;
		if(len%2==0){
			System.out.print(arr[(len/2)-1]);
		}else{
			System.out.print(arr[(len-1)/2]);
		}

	}
}
