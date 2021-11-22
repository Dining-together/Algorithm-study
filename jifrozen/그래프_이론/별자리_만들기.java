package 그래프_이론;
import java.util.*;

public class 별자리_만들기 {
	static class Position{
		private double x;
		private double y;
		public Position(double x,double y){
			this.x=x;
			this.y=y;
		}
	}
	static class Edge implements Comparable<Edge>{
		private double dist;
		private int x;
		private int y;
		public Edge(int x,int y,double dist){
			this.x=x;
			this.y=y;
			this.dist=dist;
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
		if(a==parent[a]) return a;
		return parent[a]=findParent(parent[a]);
	}

	public static void unionParent(int a,int b){
		a=findParent(a);
		b=findParent(b);
		if(a<b) parent[b]=a;
		else parent[a]=b;
	}

	public static int[] parent=new int[101];
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Position> pos=new ArrayList<>();
		ArrayList<Edge> edges=new ArrayList<>();

		for(int i=1;i<=n;i++){
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			pos.add(new Position(x,y));
			parent[i]=i;
		}

		for(int i=0;i<pos.size();i++){
			for(int j=i+1;j<pos.size();j++){
				double cost=Math.sqrt(Math.pow(pos.get(i).x-pos.get(j).x,2)+Math.pow(pos.get(i).y-pos.get(j).y,2));
				edges.add(new Edge(i,j,cost));
			}
		}

		Collections.sort(edges);
		double result=0;

		for(int i=0;i<edges.size(); i++){
			int x=edges.get(i).x;
			int y=edges.get(i).y;
			double cost=edges.get(i).dist;
			if(findParent(x)!=findParent(y)){
				unionParent(x,y);
				result+=cost;
			}
		}

		System.out.print(Math.round(result*100)/100.0);


	}
}
