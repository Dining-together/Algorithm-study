import java.util.Scanner;

import static java.lang.Math.max;

public class 카드게임 {
    public static int n;
    public static int[] left=new int[2001];
    public static int[] right=new int[2001];
    public static int[][] dp=new int[2001][2001];

    public static int getMaxScore(int leftIdx, int rightIdx){
        if(leftIdx>=n||rightIdx>=n){
            return 0;
        }
        int result=dp[leftIdx][rightIdx];
        if(result!=-1){
            return result;
        }
        dp[leftIdx][rightIdx]=max(getMaxScore(leftIdx+1,rightIdx),getMaxScore(leftIdx+1,rightIdx+1));

        if(left[leftIdx]>right[rightIdx]){
            dp[leftIdx][rightIdx]=max(dp[leftIdx][rightIdx],right[rightIdx]+getMaxScore(leftIdx,rightIdx+1));
        }
        return dp[leftIdx][rightIdx];
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n= sc.nextInt();
        for(int i=0;i<n;i++){
            left[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            right[i]=sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                dp[i][j] = -1;
        }
        System.out.println(getMaxScore(0,0));
    }
}
