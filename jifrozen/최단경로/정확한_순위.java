package 최단경로;
import java.util.*;

public class 정확한_순위 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();

		int INF=(int)1e9;

		int[][] graph=new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			Arrays.fill(graph[i],INF);
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j){
					graph[i][j]=0;
				}
			}
		}
		for(int i=1;i<=n;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			graph[a][b]=1;
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				for(int k=1;k<=n;k++){
					graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);
				}
			}
		}

		int cnt=0;
		boolean isINF=false;

		for(int i=1;i<=n;i++){
			isINF=false;
			for(int j=1;j<=n;j++) {
				if(graph[i][j]==INF&&graph[j][i]==INF) {
					isINF=true;
					break;
				}
			}
			if(!isINF) cnt+=1;
		}

		System.out.print(cnt);
	}
}
