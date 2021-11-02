package DFS_BFS;
import java.util.*;
import java.io.*;


public class 인구_이동 {
	public static int n,l,r;
	public static int[][] arr;
	public static int[][] visited=new int[51][51];
	public static int[] dx={0,-1,0,1};
	public static int[] dy={-1,0,1,0};
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
	public static void process(int a,int b,int index){
		ArrayList<Position> united=new ArrayList<>();
		Queue<Position> q=new LinkedList<>();
		int sum=arr[a][b];
		int count=1;
		q.offer(new Position(a,b));
		visited[a][b]=index;
		united.add(new Position(a,b));
		while(!q.isEmpty()){
			Position pos=q.poll();
			int x=pos.getX();
			int y=pos.getY();
			for(int i=0;i<4;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<n&&visited[nx][ny]==-1){
					int gap=Math.abs(arr[x][y]-arr[nx][ny]);
					if(gap>=l&&gap<=r){
						sum+=arr[nx][ny];
						count++;
						visited[nx][ny]=index;
						united.add(new Position(nx,ny));
						q.offer(new Position(nx,ny));
					}
				}
			}

		}
		for(int i=0;i<united.size();i++){
			int x=united.get(i).getX();
			int y=united.get(i).getY();
			arr[x][y]=sum/count;
		}

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		int answer=0;
		arr=new int[n][n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j]=-1;
				}
			}
			int index = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == -1) {
						process(i, j, index);
						index+=1;
					}
				}
			}
			if(index==n*n) break;
			answer++;
		}

		System.out.print(answer);
	}
}
