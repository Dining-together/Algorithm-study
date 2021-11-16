package 그래프_이론;

import java.util.*;
import java.io.*;

public class 커리큘럼 {
	public static int n;
	public static int[] indegree=new int[501];
	public static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
	public static int[] times=new int[501];

	public static void topologySort(){
		int[] result=new int[501];
		for(int i=1;i<=n;i++){
			result[i]=times[i];
		}

		Queue<Integer> q=new LinkedList<>();

		for(int i=1;i<=n;i++){
			if(indegree[i]==0){
				q.offer(i);
			}
		}

		while(!q.isEmpty()){
			int now=q.poll();

			for(int i=0;i<graph.get(now).size();i++){
				result[graph.get(now).get(i)]=Math.max(result[graph.get(now).get(i)],result[now]+times[graph.get(now).get(i)]);
				indegree[graph.get(now).get(i)]-=1;
				if(indegree[graph.get(now).get(i)]==0){
					q.offer(graph.get(now).get(i));
				}
			}
		}

		for(int i=1;i<=n;i++){
			System.out.println(result[i]);
		}
}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());

		for(int i=0;i<=n;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time= Integer.parseInt(st.nextToken());
			times[i]=time;
			while (true) {
				int a=Integer.parseInt(st.nextToken());
				if ( a==-1) {
					break;
				}
				indegree[i]+=1;
				graph.get(a).add(i);
			}
		}

		topologySort();
	}
}
