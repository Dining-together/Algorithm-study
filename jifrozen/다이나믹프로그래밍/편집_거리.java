package 다이나믹프로그래밍;
import java.util.*;
public class 편집_거리 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		String a=sc.next();
		String b=sc.next();

		int n=a.length();
		int m=b.length();

		int[][] dp=new int[n+1][m+1];

		for(int i=1;i<=n;i++){
			dp[i][0]=i;
		}

		for(int j=1;j<=m;j++){
			dp[0][j]=j;
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1];
				}
				else{
					dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
				}
			}
		}
		System.out.print(dp[n][m]);

	}
}
