package 그래프_이론;
import java.util.*;
public class 네트워크연결 {
	static class Edge implements Comparable<Edge>{
		private int x;
		private int y;
		private int dist;
		public Edge(int x,int y,int dist){
			this.x=x;
			this.y=y;
			this.dist=dist;
		}

		@Override
		public int compareTo(Edge other){
			if(this.dist<other.dist) return -1;
			return 1;
		}


	}
	public static int findParent(int a){
		if(a==parent[a]) return a;
		return parent[a]=findParent(parent[a]);
	}

	public static void unionParent(int a,int b){
		a=findParent(a);
		b=findParent(b);
		if(a<b) parent[b]=a;
		else parent[a]=b;
	}
	public static int[] parent=new int[1001];

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();

		for(int i=1;i<=n;i++){
			parent[i]=i;
		}
		ArrayList<Edge> edges=new ArrayList<>();

		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			edges.add(new Edge(a,b,c));
		}

		Collections.sort(edges);
		int result=0;
		for(int i=0;i<edges.size();i++){
			int x=edges.get(i).x;
			int y=edges.get(i).y;
			int cost=edges.get(i).dist;
			if(findParent(x)!=findParent(y)){
				result+=cost;
				unionParent(x,y);
			}
		}

		System.out.print(result);







	}
}
