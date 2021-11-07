import java.util.Scanner;

import static java.lang.Math.max;

public class 줄세우기 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] dp=new int[n];
        dp[0]=1;

        int ans=0;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=max(dp[i],dp[j]+1);
                }
            }
            ans=max(ans,dp[i]);
        }
        System.out.println(n-ans);
    }

}
