package 그래프_이론;
// https://www.acmicpc.net/problem/2252
import java.util.*;

public class 줄세우기 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();

		int[] indegree=new int[n+1];
		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

		for(int i=0;i<=n;i++){
			arr.add(new ArrayList<Integer>());
		}

		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr.get(a).add(b);
			indegree[b]+=1;
		}

		Queue<Integer> q=new LinkedList<>();
		ArrayList<Integer> result=new ArrayList<>();
		for(int i=1;i<=n;i++){
			if(indegree[i]==0){
				q.offer(i);
				result.add(i);
			}
		}
		while(!q.isEmpty()){
			int x=q.poll();
			for(int i=0;i<arr.get(x).size();i++){
				int e=arr.get(x).get(i);
				indegree[e]-=1;
				if(indegree[e]==0) {
					result.add(e);
					q.offer(e);
				}
			}
		}

		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+ " ");
		}
	}
}
