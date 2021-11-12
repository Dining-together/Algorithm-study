package 최단경로;
import java.util.*;
import java.io.*;

public class 역사 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int INF=(int)1e9;
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());

		int[][] graph=new int[n+1][n+1];

		for(int i=1;i<=n;i++){
			Arrays.fill(graph[i],INF);
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j) graph[i][j]=0;
			}
		}
		for(int i=0;i<k;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			graph[a][b]=1;
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				for(int l=1;l<=n;l++){
					graph[j][l]=Math.min(graph[j][l],graph[j][i]+graph[i][l]);
				}
			}
		}

		int s=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();

		for(int i=0;i<s;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(graph[a][b]!=INF){
				sb.append(-1+"\n");
			}else if(graph[b][a]!=INF){
				sb.append(1+"\n");
			}else{
				sb.append(0+"\n");
			}
		}

		System.out.print(sb.toString());


	}
}
