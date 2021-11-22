package 그래프_이론;
import java.util.*;
class Edge implements Comparable<Edge>{
	private int dist;
	private int nodeA;
	private int nodeB;

	public Edge(int dist,int nodeA,int nodeB){
		this.dist=dist;
		this.nodeA=nodeA;
		this.nodeB=nodeB;
	}

	public int getDist(){
		return this.dist;
	}

	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge other){
		return this.dist-other.dist;
	}


}
public class 도시분할계획 {

	public static int n,m;
	public static int[] parent;
	public static ArrayList<Edge> edges=new ArrayList<>();
	public static int result=0;

	public static int findParent(int a){
		if(a==parent[a]) return a;
		return parent[a]=findParent(parent[a]);
	}

	public static void union(int a,int b){
		a=findParent(a);
		b=findParent(b);

		if(a<b){
			parent[b]=a;
		}else{
			parent[a]=b;
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();

		parent=new int[n+1];

		for(int i=1;i<=n;i++){
			parent[i]=i;
		}

		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			edges.add(new Edge(c,a,b));
		}

		Collections.sort(edges);

		int last=0;
		for(int i=0;i<m;i++){
			int a=edges.get(i).getNodeA();
			int b=edges.get(i).getNodeB();
			int cost=edges.get(i).getDist();
			if(findParent(a)!=findParent(b)){
				union(a,b);
				result+=cost;
				last=cost;
			}
		}

		System.out.print(result-last);


	}
}
