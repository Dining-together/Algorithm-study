package 최단경로;
import java.util.*;
import java.io.*;

public class 최단경로 {
	static class Node implements Comparable<Node>{
		private int index;
		private int dist;

		public Node(int index,int dist){
			this.index=index;
			this.dist=dist;
		}

		public int getIndex(){
			return this.index;
		}

		public int getDist(){
			return this.dist;
		}

		@Override
		public int compareTo(Node other){
			if(this.dist<other.dist){
				return -1;
			}
			return 1;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int INF=(int)1e9;
		StringTokenizer st=new StringTokenizer(br.readLine());
		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());

		int start=Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Node>> nodes=new ArrayList<>();
		int[] d=new int[v+1];

		Arrays.fill(d,INF);

		for(int i=1;i<=v+1;i++){
			nodes.add(new ArrayList<Node>());
		}

		for(int i=0;i<e;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			nodes.get(a).add(new Node(b,c));
		}


		PriorityQueue<Node> pq=new PriorityQueue<>();
		d[start]=0;
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()){
			Node node=pq.poll();
			int index=node.getIndex();
			int dist=node.getDist();
			if(d[index]<dist) continue;
			for(int i=0;i<nodes.get(index).size();i++){
				int cost=dist+nodes.get(index).get(i).getDist();
				if(cost<d[nodes.get(index).get(i).getIndex()]){
					d[nodes.get(index).get(i).getIndex()]=cost;
					pq.offer(new Node(nodes.get(index).get(i).getIndex(),cost));
				}
			}
		}


		for(int i=1;i<=v;i++){
			if(d[i]==INF){
				System.out.println("INF");
			}else{
				System.out.println(d[i]);
			}
		}



	}
}
