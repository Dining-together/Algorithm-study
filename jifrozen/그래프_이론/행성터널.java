package 그래프_이론;
import java.util.*;

public class 행성터널 {
	static class Position implements Comparable<Position>{
		private int x;
		private int y;
		public Position(int x,int y){
			this.x=x;
			this.y=y;
		}

		@Override
		public int compareTo(Position other){
			if(this.x==other.x){
				return Integer.compare(this.y,this.y);
			}
			return Integer.compare(this.x,other.x);
		}
	}
	static class Edge implements Comparable<Edge>{
		private int dist;
		private int nodeA;
		private int nodeB;
		public Edge(int dist,int nodeA,int nodeB){
			this.dist=dist;
			this.nodeA=nodeA;
			this.nodeB=nodeB;
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

	public static int[] parent=new int[100001];
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();

		ArrayList<Position> x=new ArrayList<>();
		ArrayList<Position> y=new ArrayList<>();
		ArrayList<Position> z=new ArrayList<>();
		for(int i=1;i<=n;i++){
			parent[i]=i;
		}


		for(int i=1;i<=n;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			x.add(new Position(a,i));
			y.add(new Position(b,i));
			z.add(new Position(c,i));
		}

		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);

		ArrayList<Edge> edges=new ArrayList<>();

		for(int i=0;i<n-1;i++){
			edges.add(new Edge(x.get(i+1).x-x.get(i).x,x.get(i+1).y,x.get(i).y));
			edges.add(new Edge(y.get(i+1).x-y.get(i).x,y.get(i+1).y,y.get(i).y));
			edges.add(new Edge(z.get(i+1).x-z.get(i).x,z.get(i+1).y,z.get(i).y));
		}

		Collections.sort(edges);
		int result=0;

		for(int i=0;i<edges.size();i++){
			int a=edges.get(i).nodeA;
			int b=edges.get(i).nodeB;
			int cost=edges.get(i).dist;
			if(findParent(a)!=findParent(b)){
				unionParent(a,b);
				result+=cost;

			}
		}

		System.out.print(result);





	}
}
