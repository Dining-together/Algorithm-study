package 다이나믹프로그래밍;
import java.io.*;
import java.util.*;

public class 카드게임하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		int[] rightCard=new int[n+1];
		int[] leftCard=new int[n+1];
		int[][] dp=new int[n+1][n+1];
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){

			leftCard[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){

			rightCard[i]=Integer.parseInt(st.nextToken());
		}


		for(int i=n-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(leftCard[i]>rightCard[j]){
					dp[i][j]=dp[i][j+1]+rightCard[j];
				}
				else{
					dp[i][j]=Math.max(dp[i+1][j+1],dp[i+1][j]);
				}
			}
		}

		System.out.print(dp[0][0]);
	}

}
