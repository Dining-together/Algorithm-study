import java.util.Scanner;

import static java.lang.Math.max;

public class 병사_배치하기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }

        int[] dp=new int[n+1];

        int ans=0;
        for(int i=1;i<=n;i++){
            dp[i]=1;
            for(int j=1;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i]=max(dp[i],dp[j]+1);
                }
            }
            ans=max(dp[i],ans);
        }
        System.out.println(n-ans);
    }
}
