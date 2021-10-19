package DFS_BFS;
import java.util.*;

public class 음료수_얼려_먹기 {
	public static int[][] arr={
		{0,0,1,1,0},{0,0,0,1,1},{1,1,1,1,1},{0,0,0,0,0}
	};
	public static boolean dfs(int a,int b){
		if(a<=-1||a>=4||b<=-1||b>=5){
			return false;
		}
		if(arr[a][b]==0) {
			arr[a][b] = 1;
			dfs(a-1,b);
			dfs(a+1,b);
			dfs(a,b-1);
			dfs(a,b+1);
			return true;
		}
		return false;
	}
	public static void main(String[] agrs){
		int result=0;

		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				if(dfs(i,j)){
					result+=1;
				}
			}
		}
		System.out.print(result);

	}
}
