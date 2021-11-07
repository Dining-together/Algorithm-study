import java.util.Scanner;

import static java.lang.Math.max;

public class LCS{
    public static int[][] dp=new int[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1=sc.nextLine();
        String word2=sc.nextLine();

        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[word1.length()][word2.length()]);
    }
}
