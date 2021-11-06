package 다이나믹프로그래밍;
import java.util.*;

public class 효율적인_화폐_구성 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();

		int[] moneys=new int[n];
		for(int i=0;i<n;i++){
			moneys[i]=sc.nextInt();
		}

		int[] dp=new int[m+1];
		Arrays.fill(dp,10001);
		dp[0]=0;

		for(int money:moneys){
			for(int i=money;i<=m;i++){
				if(dp[i-money]!=10001) {
					dp[i] = Math.min(dp[i], dp[i - money] + 1);
				}
			}
		}

		if(dp[m]==10001){
			System.out.print(-1);
		}else{
			System.out.print(dp[m]);
		}

	}
}
