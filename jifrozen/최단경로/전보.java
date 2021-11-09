package 최단경로;
import java.util.*;

public class 전보 {
	static class Node implements Comparable<Node>{
		private int index;
		private int distance;


		public Node(int index,int distance){
			this.index=index;
			this.distance=distance;
		}
		public int getIndex() {
			return index;
		}

		public int getDistance() {
			return distance;
		}

		@Override
		public int compareTo(Node other){
			if(this.distance< other.distance){
				return -1;
			}
			return 1;
		}

	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int INF=(int)1e9;

		int n=sc.nextInt();
		int m=sc.nextInt();
		int c=sc.nextInt();

		ArrayList<ArrayList<Node>> nodes=new ArrayList<>();
		int[] d=new int[n+1];

		Arrays.fill(d,INF);

		for(int i=0;i<=n;i++){
			nodes.add(new ArrayList<Node>());
		}

		for(int i=0;i<m;i++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			nodes.get(x).add(new Node(y,z));
		}

		d[c]=0;
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(c,0));
		while(!pq.isEmpty()){
			Node node=pq.poll();
			int now=node.getIndex();
			int dist=node.getDistance();
			if(d[now]<dist) continue;
			for(int i=0;i<nodes.get(now).size();i++){
				int cost=dist+nodes.get(now).get(i).getDistance();
				if(cost<d[nodes.get(now).get(i).getIndex()]){
					d[nodes.get(now).get(i).getIndex()]=cost;
					pq.offer(new Node(nodes.get(now).get(i).getIndex(),cost));
				}
			}
		}

		int count=0;
		int maxValue=0;
		for(int i=1;i<=n;i++){
			if(d[i]!=INF){
				count+=1;
				maxValue=Math.max(maxValue,d[i]);
			}
		}

		System.out.print(count-1+ " "+maxValue);

	}
}
