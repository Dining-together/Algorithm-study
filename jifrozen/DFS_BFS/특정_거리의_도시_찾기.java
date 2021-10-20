package DFS_BFS;
import java.util.*;
import java.io.*;

public class 특정_거리의_도시_찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
		int[] visited=new int[n+1];

		for(int i=0;i<n+1;i++){
			arr.add(new ArrayList<Integer>());
		}

		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
		}

		Queue<Integer> q=new LinkedList<>();
		q.offer(x);
		visited[x]=1;
		while(!q.isEmpty()){
			int c=q.poll();
			ArrayList<Integer> temp=arr.get(c);
			for(int i=0;i<temp.size();i++){
				if(visited[temp.get(i)]==0) {
					visited[temp.get(i)]+=visited[c]+1;
					q.offer(temp.get(i));
				}
			}
		}
		ArrayList<Integer> answer=new ArrayList<>();
		boolean check=false;
		for(int i=1;i<n+1;i++){
			if((visited[i]-1)==k){
				System.out.println(i);
				check=true;
			}
		}

		if(!check){
			System.out.println(-1);
		}









	}
}
