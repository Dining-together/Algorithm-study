package 최단경로;
import java.util.*;

public class 숨바꼭질 {
	static class Node implements Comparable<Node>{
		private int index;
		private int dist;

		public Node(int index,int dist){
			this.index=index;
			this.dist=dist;
		}

		public int getIndex() {
			return index;
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
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int INF=(int)1e9;

		ArrayList<ArrayList<Node>> nodes=new ArrayList<>();
		int[] d=new int[n+1];
		Arrays.fill(d,INF);
		for(int i=0;i<=n;i++){
			nodes.add(new ArrayList<Node>());
		}


		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			nodes.get(a).add(new Node(b,1));
			nodes.get(b).add(new Node(a,1));
		}

		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.offer(new Node(1,0));
		d[1]=0;

		while(!pq.isEmpty()){
			Node node=pq.poll();
			int a=node.getIndex();
			int b=node.getDist();
			if(d[a]<b) continue;
			for(int i=0;i<nodes.get(a).size();i++){
				int cost=b+nodes.get(a).get(i).getDist();
				if(cost<d[nodes.get(a).get(i).getIndex()]){
					d[nodes.get(a).get(i).getIndex()]=cost;
					pq.offer(new Node(nodes.get(a).get(i).getIndex(),cost));
				}
			}
		}
		ArrayList<Integer> result=new ArrayList<>();
		int maxDistance=0;

		for(int i=1;i<=n;i++){
			if(d[i]>maxDistance){
				maxDistance=d[i];
				result.clear();
				result.add(i);
			}else if(d[i]==maxDistance) result.add(i);
		}

		Collections.sort(result);
		System.out.print(result.get(0)+" "+maxDistance+" "+result.size());

	}
}
