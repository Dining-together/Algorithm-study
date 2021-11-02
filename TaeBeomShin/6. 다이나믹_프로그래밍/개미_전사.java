import java.util.Scanner;

public class 개미_전사 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[101];
        int[] dp=new int[102];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        dp[0]=0;dp[1]=arr[0];
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i-1]);
        }
        System.out.println(dp[n]);
    }
}
