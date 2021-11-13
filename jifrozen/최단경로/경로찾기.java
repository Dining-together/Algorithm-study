package 최단경로;
import java.util.*;

public class 경로찾기 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int INF=(int)1e9;

		int n=sc.nextInt();
		int[][] graph=new int[n+1][n+1];

		for(int i=0;i<n;i++){
			Arrays.fill(graph[i],INF);
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(sc.nextInt()==1){
					graph[i][j]=1;
				}
			}
		}

		for(int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < n; l++) {
					graph[j][l] = Math.min(graph[j][l], graph[j][i] + graph[i][l]);
				}
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(graph[i][j]==INF){
					System.out.print(0+ " ");
				}else{
					System.out.print(1+ " ");
				}
			}
			System.out.println();
		}






	}
}
