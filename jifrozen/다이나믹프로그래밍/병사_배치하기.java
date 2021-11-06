package 다이나믹프로그래밍;
import java.util.*;
import java.io.*;

public class 병사_배치하기 {
	public static int[] dp=new int[2001];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ArrayList<Integer> arr=new ArrayList<>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr.add(Integer.parseInt(st.nextToken()));
		}

		Collections.reverse(arr);

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr.get(j)<arr.get(i)){
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
		}

		int maxValue=0;
		for(int i=0;i<n;i++){
			maxValue=Math.max(maxValue,dp[i]);
		}
		System.out.println(n-maxValue);





	}
}
