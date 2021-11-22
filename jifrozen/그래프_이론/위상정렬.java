package 그래프_이론;
import java.util.*;

public class 위상정렬 {
	public static int v,e;
	public static int[] indegree=new int[100001];
	public static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();

	public static void topologySort(){
		ArrayList<Integer> result=new ArrayList<>();
		Queue<Integer> q=new LinkedList<>();

		for(int i=1;i<=v;i++){
			if(indegree[i]==0){
				q.offer(i);
			}
		}

		while(!q.isEmpty()){
			int now=q.poll();
			result.add(now);
			for(int i=0;i<graph.get(now).size();i++){
				indegree[graph.get(now).get(i)]-=1;
				if(indegree[graph.get(now).get(i)]==0){
					q.offer(graph.get(now).get(i));
				}
			}
		}

		// 위상 정렬을 수행한 결과 출력
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		v=sc.nextInt();
		e=sc.nextInt();

		for(int i=1;i<=v;i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int i=0;i<e;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			graph.get(a).add(b);
			indegree[b]+=1;
		}

		topologySort();
	}
}
