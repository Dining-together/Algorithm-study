import java.util.Scanner;

public class 일로_만들기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        dp[1]=0;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+1;
            if(i%5==0){
                dp[i]=Math.min(dp[i],dp[i/5]+1);
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
