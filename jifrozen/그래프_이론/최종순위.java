package 그래프_이론;
import java.util.*;
public class 최종순위 {
	public static int[] indegree=new int[501];
	public static boolean[][] graph=new boolean[501][501];

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		for(int tc=0;tc<testCase;tc++) {
			Arrays.fill(indegree,0);
			for(int i=0;i<501;i++){
				Arrays.fill(graph[i],false);
			}
			int n=sc.nextInt();
			ArrayList<Integer> arr=new ArrayList<>();
			for(int i=0;i<n;i++){
				int x=sc.nextInt();
				arr.add(x);
			}

			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					graph[arr.get(i)][arr.get(j)]=true;
					indegree[arr.get(j)]+=1;
				}
			}

			int m=sc.nextInt();
			for(int i=0;i<m;i++){
				int a=sc.nextInt();
				int b=sc.nextInt();
				if(graph[a][b]){
					graph[a][b]=false;
					graph[b][a]=true;
					indegree[a]+=1;
					indegree[b]-=1;
				}else{
					graph[b][a]=false;
					graph[a][b]=true;
					indegree[a]-=1;
					indegree[b]+=1;
				}
			}

			ArrayList<Integer> result=new ArrayList<>();
			Queue<Integer> q=new LinkedList<>();

			for(int i=1;i<=arr.size();i++){
				if(indegree[i]==0){
					q.offer(i);
				}
			}

			boolean certain=true;
			boolean cycle=false;

			for(int i=0;i<n;i++){
				if(q.size()==0){
					cycle=true;
					break;
				}

				if(q.size()>=2){
					certain=false;
					break;
				}

				int now=q.poll();
				result.add(now);

				for(int j=1;j<=n;j++){
					if(graph[now][j]){
						indegree[j]-=1;
						if(indegree[j]==0){
							q.offer(j);
						}
					}
				}
			}

			if(cycle) System.out.println("IMPOSSIBLE");
			else if(!certain) System.out.println("?");
			else{
				for(int i=0;i<result.size();i++){
					System.out.print(result.get(i)+ " ");
				}
				System.out.println();
			}
		}
	}
}
