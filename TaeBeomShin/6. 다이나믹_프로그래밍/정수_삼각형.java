import java.util.Scanner;

public class 정수_삼각형 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[][] arr=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int[][] dp=new int[n+1][n+1];

        dp[1][1]=arr[1][1];


        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]=arr[i][j];
                if(j-1>=1){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+arr[i][j]);
                }
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]+arr[i][j]);

            }
        }

        int ans=0;

        for(int i=1;i<=n;i++){
            ans=Math.max(ans,dp[n][i]);
        }
        System.out.println(ans);
    }
}
