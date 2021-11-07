import java.util.Scanner;

public class 암호코드 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String string=sc.nextLine();
        int n= string.length();
        long[] dp=new long[n+1]; dp[0]=dp[1]=1;

        if(string.charAt(0)=='0'){
            System.out.println(0);
        }
        else  if(string.charAt(n-1)=='0' && Integer.parseInt(string.substring(n-2,n))>20){
            System.out.println(0);
        }else{
            for(int i=2;i<=n;i++){
                if(string.charAt(i-1)-'0'>0){
                    dp[i]=dp[i-1]%1000000;
                }
                int num=Integer.parseInt(string.substring(i-2,i));
                if(num>=10 && num<=26) {
                    dp[i] = (dp[i] + dp[i - 2]) % 1000000;
                }
            }
            System.out.println(dp[n]);
        }

    }
}
