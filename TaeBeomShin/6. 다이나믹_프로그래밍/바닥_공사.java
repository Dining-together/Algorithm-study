import java.util.Scanner;

public class 바닥_공사 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[1001];
        dp[0]=0;dp[1]=1;dp[2]=3;dp[3]=5;

        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+2*dp[i-2])%796796;
        }
        System.out.println(dp[n]);
    }
}