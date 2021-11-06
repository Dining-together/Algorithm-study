package 다이나믹프로그래밍;
import java.util.*;
public class 설탕배달 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();

		int[] sweet={3,5};

		int[] dp=new int[n+1];
		Arrays.fill(dp,5001);
		dp[0]=0;
		for(int s:sweet){
			for(int i=s;i<=n;i++){
				if(dp[i-s]!=5001){
					dp[i]=Math.min(dp[i],dp[i-s]+1);
				}
			}
		}

		if(dp[n]==5001){
			System.out.print(-1);
		}else{
			System.out.print(dp[n]);
		}

	}
}
