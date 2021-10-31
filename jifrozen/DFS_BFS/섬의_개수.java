package DFS_BFS;
import java.util.*;
import java.io.*;

public class 섬의_개수 {
	public static int w,h;
	public static int[] dx={0,-1,0,1,-1,-1,1,1};
	public static int[] dy={-1,0,1,0,1,-1,1,-1};
	public static int[][] visited;
	public static int[][] map;
	static class Position{
		private int x;
		private int y;

		public Position(int x,int y){
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
	public static void process(int x,int y){
		Queue<Position> q=new LinkedList<>();
		q.offer(new Position(x,y));
		visited[x][y]=1;
		while(!q.isEmpty()){
			Position pos=q.poll();
			int a=pos.getX();
			int b=pos.getY();
			for(int i=0;i<8;i++){
				int nx=a+dx[i];
				int ny=b+dy[i];
				if(nx>=0&&nx<h&&ny>=0&&ny<w&&visited[nx][ny]==0&&map[nx][ny]==1){
					q.offer(new Position(nx,ny));
					visited[nx][ny]=1;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			if(w==0&&h==0) break;
			map=new int[h][w];
			visited=new int[h][w];
			for(int i=0;i<h;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int cnt=0;
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(visited[i][j]==0&&map[i][j]==1){
						process(i,j);
						cnt+=1;
					}
				}
			}

			System.out.println(cnt);
		}
	}
}
