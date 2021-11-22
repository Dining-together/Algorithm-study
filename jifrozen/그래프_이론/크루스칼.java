package 그래프_이론;
import java.util.*;

public class 크루스칼 {

	public static int v,e;
	public static int[] parent=new int[10001];

	public static ArrayList<Edge> edges=new ArrayList<>();
	public static int result=0;

	static class Edge implements Comparable<Edge>{
		private int dist;
		private int nodeA;
		private int nodeB;

		public Edge(int dist,int nodeA,int nodeB){
			this.dist=dist;
			this.nodeA=nodeA;
			this.nodeB=nodeB;
		}

		public int getDistance(){
			return this.dist;
		}

		public int getNodeA(){
			return this.nodeA;
		}

		public int getNodeB(){
			return this.nodeB;
		}

		@Override
		public int compareTo(Edge other){
			if(this.dist<other.dist){
				return -1;
			}
			return 1;
		}
	}

	public static int findParent(int a){
		if(parent[a]==a) return a;
		return parent[a]=findParent(parent[a]);
	}

	public static void unionParent(int a,int b){
		a=findParent(a);
		b=findParent(b);
		if(a<b) parent[b]=a;
		else parent[a]=b;
	}
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);

		v=sc.nextInt();
		e=sc.nextInt();

		for(int i=1;i<=v;i++){
			parent[i]=i;
		}

		for(int i=0;i<e;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int cost=sc.nextInt();
			edges.add(new Edge(cost,a,b));
		}

		Collections.sort(edges);

		for(int i=0;i<edges.size();i++){
			int cost=edges.get(i).getDistance();
			int a=edges.get(i).getNodeA();
			int b=edges.get(i).getNodeB();
			if(findParent(a)!=findParent(b)){
				unionParent(a,b);
				result+=cost;
			}
		}
		System.out.print(result);

	}
}
