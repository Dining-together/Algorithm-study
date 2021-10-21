package DFS_BFS;
import java.util.*;
import java.io.*;

public class 연산자_끼워넣기 {
	public static ArrayList<Integer> arr=new ArrayList<>();
	public static int n, add, sub, multi,div;
	public static int minValue=(int)1e9;
	public static int maxValue=(int)-1e9;
	public static void dfs(int i,int now){
		if(i==n){
			minValue=Math.min(minValue,now);
			maxValue=Math.max(maxValue,now);
		}
		else{
			if(add>0){
				add--;
				dfs(i+1,now+arr.get(i));
				add++;
			}
			if(sub>0){
				sub--;
				dfs(i+1,now-arr.get(i));
				sub++;
			}
			if(multi>0){
				multi--;
				dfs(i+1,now*arr.get(i));
				multi++;
			}
			if(div>0){
				div--;
				dfs(i+1,now/arr.get(i));
				div++;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++){
			arr.add(Integer.parseInt(st.nextToken()));
		}
		st=new StringTokenizer(br.readLine());
		add=Integer.parseInt(st.nextToken());
		sub=Integer.parseInt(st.nextToken());
		multi=Integer.parseInt(st.nextToken());
		div=Integer.parseInt(st.nextToken());

		dfs(1,arr.get(0));

		System.out.println(maxValue);
		System.out.println(minValue);


	}
}
