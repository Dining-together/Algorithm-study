package 다이나믹프로그래밍;
import java.util.*;
import java.io.*;

public class 계단오르기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] st=new int[n+1];
		for(int i=1;i<=n;i++){
			st[i]=Integer.parseInt(br.readLine());
		}

		int[] dp=new int[n+1];
		dp[1]=st[1];
		if(n>=2){
			dp[2]=st[1]+st[2];
		}

		for(int i=3;i<=n;i++){
			dp[i]=st[i]+Math.max(st[i-1]+dp[i-3],dp[i-2]);
		}

		System.out.print(dp[n]);
	}
}
