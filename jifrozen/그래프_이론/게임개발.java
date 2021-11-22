package 그래프_이론;
import java.util.*;

public class 게임개발 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] indegree=new int[n+1];
		int[] building=new int[n+1];
		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

		for(int i=0;i<=n;i++){
			arr.add(new ArrayList<>());
		}

		for(int i=1;i<=n;i++){
			int x=sc.nextInt();
			building[i]=x;
			while(true){
				x=sc.nextInt();
				if(x==-1){
					break;
				}
				indegree[i]+=1;
				arr.get(x).add(i);
			}
		}

		Queue<Integer> q=new LinkedList<>();

		int[] result=new int[n+1];

		for(int i=1;i<=n;i++){
			result[i]=building[i];
		}

		for(int i=1;i<=n;i++){
			if(indegree[i]==0){
				q.offer(i);
			}
		}

		while(!q.isEmpty()){
			int x=q.poll();
			for(int i=0;i<arr.get(x).size();i++){
				int e=arr.get(x).get(i);
				result[e]=Math.max(result[e],result[x]+building[e]);
				indegree[e]-=1;
				if(indegree[e]==0){
					q.offer(e);
				}
			}

		}

		for(int i=1;i<=n;i++){
			System.out.println(result[i]);
		}

	}
}
