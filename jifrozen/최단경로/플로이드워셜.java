package 최단경로;
import java.util.*;

public class 플로이드워셜 {
	public static final int INF=(int)1e9;
	public static int n,m;
	public static int[][] graph=new int[501][501];

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();
		m= sc.nextInt();

		for(int i=0;i<501;i++){
			Arrays.fill(graph[i],INF);
		}

		for(int a=1;a<=n;a++){
			for(int b=1;b<=n;b++){
				if(a==b) graph[a][b]=0;
			}
		}

		for(int i=0;i<m;i++){
			// A에서 B로 가는 비용은 C라고 설정
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph[a][b]=c;
		}

		for(int k=1;k<=n;k++){
			for(int a=1;a<=n;a++){
				for(int b=1;b<=n;b++){
					graph[a][b]=Math.min(graph[a][b],graph[a][k]+graph[k][b]);
				}
			}
		}

		for(int a=1;a<=n;a++){
			for(int b=1;b<=n;b++){
				if(graph[a][b]==INF){
					System.out.print("INF");
				}
				else{
					System.out.print(graph[a][b]+ " ");
				}
			}
			System.out.println();
		}
	}
}
