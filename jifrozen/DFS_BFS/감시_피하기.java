package DFS_BFS;
import java.util.*;
import java.io.*;
class Combination{
	private int n;
	private int r;
	private int[] now;
	private ArrayList<ArrayList<Position>> result;

	public ArrayList<ArrayList<Position>> getResult(){
		return this.result;
	}

	public Combination(int n,int r){
		this.n=n;
		this.r=r;
		this.now=new int[r];
		this.result=new ArrayList<ArrayList<Position>>();
	}

	public void combination(ArrayList<Position> arr,int depth,int index,int target){
		if(depth==r){
			ArrayList<Position> temp=new ArrayList<>();
			for(int i=0;i<r;i++){
				temp.add(arr.get(now[i]));
			}
			result.add(temp);
			return;
		}
		if(target==n) return;
		now[index]=target;
		combination(arr,depth+1,index+1,target+1);
		combination(arr,depth,index,target+1);
	}

}
class Position{
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
public class 감시_피하기 {
	public static int n;
	public static ArrayList<Position> spaces=new ArrayList<>();
	public static ArrayList<Position> teachers=new ArrayList<>();
	public static String[][] arr;

	public static boolean watch(int x,int y,int direction){
		if(direction==0){
			while(y>=0){
				if(arr[x][y].equals("S")) return true;
				if(arr[x][y].equals("O")) return false;
				y--;
			}
		}
		if(direction==1){
			while(y<n){
				if(arr[x][y].equals("S")) return true;
				if(arr[x][y].equals("O")) return false;
				y++;
			}
		}
		if(direction==2){
			while(x>=0){
				if(arr[x][y].equals("S")) return true;
				if(arr[x][y].equals("O")) return false;
				x--;
			}
		}
		if(direction==3){
			while(x<n){
				if(arr[x][y].equals("S")) return true;
				if(arr[x][y].equals("O")) return false;
				x++;
			}
		}
		return false;
	}

	public static boolean checkS(){
		for(int i=0;i<teachers.size();i++){
			int x=teachers.get(i).getX();
			int y=teachers.get(i).getY();
			for(int j=0;j<4;j++) {
				if(watch(x, y,j)){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr=new String[n][n];

		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				arr[i][j]= st.nextToken();
				if(arr[i][j].equals("X")) spaces.add(new Position(i,j));
				if(arr[i][j].equals("T")) teachers.add(new Position(i,j));
			}
		}

		Combination comb=new Combination(spaces.size(),3);
		comb.combination(spaces,0,0,0);
		ArrayList<ArrayList<Position>> spaceList=comb.getResult();

		boolean found=false;
		for(int i=0;i<spaceList.size();i++){
			for(int j=0;j<spaceList.get(i).size();j++){
				int x=spaceList.get(i).get(j).getX();
				int y=spaceList.get(i).get(j).getY();
				arr[x][y]="O";
			}
			if(!checkS()){
				found=true;
				break;
			}
			for(int j=0;j<spaceList.get(i).size();j++){
				int x=spaceList.get(i).get(j).getX();
				int y=spaceList.get(i).get(j).getY();
				arr[x][y]="X";
			}
		}

		if(found) System.out.print("YES");
		else System.out.print("NO");







	}
}
