package 다이나믹프로그래밍;
import java.util.*;
public class 개미_전사 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int[] d=new int[101];
		d[0]=arr[0];
		d[1]=Math.max(arr[0],arr[1]);
		for(int i=2;i<n;i++){
			d[i]=Math.max(d[i-1],d[i-2]+arr[i]);
		}

		System.out.print(d[n-1]);
	}
}
