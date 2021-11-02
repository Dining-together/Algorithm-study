import java.util.Scanner;

public class 퇴사 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] T=new int[n+2];
        int[] P=new int[n+2];
        int[] dp=new int[n+2];

        for(int i=1;i<=n;i++){
            T[i]=sc.nextInt();
            P[i]=sc.nextInt();
        }

        for(int i=n;i>=1;i--){
            int time=T[i]+i;
            if(time<=n+1){
                dp[i]=Math.max(P[i]+dp[time],dp[i+1]);
            }else{
                dp[i]=dp[i+1];
            }
        }
        System.out.println(dp[1]);
    }
}
