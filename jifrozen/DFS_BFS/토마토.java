package DFS_BFS;
import java.util.*;
import java.io.*;

public class 토마토 {
	static class Position{
		private int x;
		private int y;
		private int day;

		public Position(int x,int y,int day){
			this.x=x;
			this.y=y;
			this.day=day;
		}

		public int getX(){
			return this.x;
		}

		public int getY(){
			return this.y;
		}

		public int getDay(){
			return this.day;
		}
	}
	public static int m,n;
	public static int[][] arr;
	public static ArrayList<Position> pos=new ArrayList<>();
	public static int[] dx={0,-1,0,1};
	public static int[] dy={-1,0,1,0};

	public static int process(ArrayList<Position> pos){
		Queue<Position> q=new LinkedList<>();
		for(int i=0;i<pos.size();i++) {
			Position p=pos.get(i);
			q.offer(new Position(p.getX(), p.getY(), p.getDay()));
		}
		int d=0;
		while(!q.isEmpty()){
			Position ps=q.poll();
			int x=ps.getX();
			int y=ps.getY();
			d=ps.getDay();
			for(int i=0;i<4;i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&arr[nx][ny]==0){
					q.offer(new Position(nx,ny,d+1));
					arr[nx][ny]=1;
				}
			}
		}
		return d;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		arr=new int[n][m];

		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) pos.add(new Position(i,j,0));
			}
		}
		int day=0;
		day=process(pos);
		boolean checkZero=false;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(arr[i][j]==0){
					checkZero=true;
					break;
				}
			}
		}

		if(checkZero){
			System.out.print(-1);
		}else{
			System.out.print(day);
		}


	}
}
