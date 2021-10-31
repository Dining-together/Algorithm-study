package DFS_BFS;
import java.util.*;
import java.io.*;
class Node{
	private int x;
	private int y;

	public Node(int x,int y){
		this.x=x;
		this.y=y;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

}
public class 미로틸출 {
	public static int[] dx={-1,0,1,0};
	public static int[] dy={0,-1,0,1};
	public static int n,m;
	public static int[][] arr=new int[201][201];

	public static int bfs(int a,int b){
		Queue<Node> q=new LinkedList<>();
		q.offer(new Node(a,b));
		while(!q.isEmpty()){
			Node node=q.poll();
			int x=node.getX();
			int y=node.getY();
			for(int i=0;i<4;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||nx>n||ny<0||ny>m){
					continue;
				}
				if(arr[nx][ny]==0) continue;
				if(arr[nx][ny]==1){
					arr[nx][ny]=arr[x][y]+1;
					q.offer(new Node(nx,ny));
				}
			}
		}
		return arr[n-1][m-1];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());

		for(int i=0;i<n;i++){
			String str=br.readLine();
			for(int j=0;j<m;j++){
				arr[i][j]=str.charAt(j)-'0';
			}
		}

		System.out.print(bfs(0,0));
	}
}
