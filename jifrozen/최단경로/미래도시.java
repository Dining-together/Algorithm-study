package 최단경로;
import java.util.*;

public class 미래도시 {
	static int INF=(int)1e9;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();

		int[][] graph=new int[n+1][n+1];

		for(int i=0;i<=n;i++){
			Arrays.fill(graph[i],INF);
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j){
					graph[i][j]=0;
				}
			}
		}
		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			graph[a][b]=1;
			graph[b][a]=1;
		}

		int x=sc.nextInt();
		int k=sc.nextInt();


		for(int i=1;i<=n;i++) {
			for (int j = 1; j <= n; j++) {
				for (int l = 1; l <= n; l++) {
					graph[j][l]=Math.min(graph[j][l],graph[j][i]+graph[i][l]);
				}
			}
		}

		if(graph[1][k]+graph[k][x]>=INF){
			System.out.println(-1);
		}else{
			System.out.println(graph[1][k]+graph[k][x]);
		}

	}
}
