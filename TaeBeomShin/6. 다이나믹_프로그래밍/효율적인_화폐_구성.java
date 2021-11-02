import java.util.Arrays;
import java.util.Scanner;

public class 효율적인_화폐_구성 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[] arr=new int[n+1];
        int[] dp=new int[m+1];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        Arrays.fill(dp,100002);

        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=m;j++){
                if(dp[j-arr[i]]!=10001){
                    dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
                }
            }
        }

        if(dp[m]>=10001){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}
