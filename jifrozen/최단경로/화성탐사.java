package 최단경로;
import java.util.*;

public class 화성탐사 {
	static class Node implements Comparable<Node>{
		private int x;
		private int y;
		private int dist;

		public Node(int x,int y,int dist){
			this.x=x;
			this.y=y;
			this.dist=dist;
		}

		public int getX(){
			return this.x;
		}

		public int getY(){
			return this.y;
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
		int[] dx={0,-1,0,1};
		int[] dy={1,0,-1,0};
		int t=sc.nextInt();
		int INF=(int)1e9;
		while(t>0){
			t-=1;
			int n=sc.nextInt();

			int[][] graph=new int[n][n];
			int[][] d=new int[n][n];

			for(int i=0;i<n;i++){
				Arrays.fill(d[i],INF);
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					graph[i][j]=sc.nextInt();
				}
			}

			PriorityQueue<Node> pq=new PriorityQueue<>();
			pq.offer(new Node(0,0,graph[0][0]));
			while(!pq.isEmpty()){
				Node node=pq.poll();
				int a=node.getX();
				int b=node.getY();
				int c=node.getDist();
				if(d[a][b]<c) continue;
				d[a][b]=c;
				for(int i=0;i<4;i++){
					int nx=a+dx[i];
					int ny=b+dy[i];
					if(nx>=0&&nx<n&&ny>=0&&ny<n){
						int cost=c+graph[nx][ny];
						if(cost<d[nx][ny]){
							d[nx][ny]=cost;
							pq.offer(new Node(nx,ny,cost));
						}
					}
				}

			}

			System.out.println(d[n-1][n-1]);
		}
	}
}
