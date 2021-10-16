package 정렬;
import java.util.*;
import java.io.*;
public class ATM {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int result=0;
		int len=n;
		for(int p1=0;p1<n;p1++){
			result+=arr[p1]*len;
			len--;
		}
		System.out.print(result);


	}
}
