package 다이나믹프로그래밍;
import java.util.*;
import java.io.*;

public class 정수삼각형 {
	public static int[][] dp=new int[500][500];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++){
				dp[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i+1;j++) {
				int up,upLeft;
				if(j==0) upLeft=0;
				else upLeft=dp[i-1][j-1];
				if(j==i) up=0;
				else up=dp[i-1][j];
				dp[i][j]=dp[i][j]+Math.max(up,upLeft);
			}
		}

		int result=0;
		for(int i=0;i<n;i++){
			result=Math.max(result,dp[n-1][i]);
		}
		System.out.print(result);
	}
}
