package 정렬;
import java.io.*;
import java.util.*;
public class 전화번호_목록 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int test=0;test<t;test++){
			int n=Integer.parseInt(br.readLine());
			String[] arr=new String[n];
			for(int i=0;i<n;i++){
				arr[i]=br.readLine();
			}
			Arrays.sort(arr);
			int isSw=0;
			for(int i=1;i<n;i++) {
				if (arr[i].startsWith(arr[i-1])) {
					isSw=1;
					break;
				}
			}
			System.out.println(isSw==0?"YES":"NO");

		}


	}
}

