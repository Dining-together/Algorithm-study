package 최단경로;
import java.util.*;

public class 택배 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();
		int INF=(int)1e9;

		int[][] graph=new int[n+1][n+1];
		int[][] answer=new int[n+1][n+1];


		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j){
					graph[i][j]=0;
				}else{
					graph[i][j]=INF;
				}
			}
		}

		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			graph[a][b]=c;
			graph[b][a]=c;
			answer[a][b]=b;
			answer[b][a]=a;
		}

		for(int i=n;i>=1;i--) {
			for (int j = 1; j <= n; j++) {
				for (int l = 1; l <= n; l++) {
					if(graph[j][l]>graph[j][i]+graph[i][l]){
						graph[j][l]=graph[j][i]+graph[i][l];
						answer[j][l]= i;
					}
				}
			}
		}

		for(int i=1;i<=n;i++) {
			for (int j = 1; j <= n; j++) {
				if(answer[i][j]==0){
					System.out.print("- ");
				}else {
					int t = j;
					while (answer[i][t] != t) {
						t = answer[i][t];
					}
					System.out.print(answer[i][t] + " ");
				}
			}
			System.out.println();
		}



	}
}
