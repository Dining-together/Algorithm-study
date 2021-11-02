package 정렬;
import java.util.*;
import java.io.*;

public class 회의실_배정 {
	static class Node implements Comparable<Node>{
		private int start;
		private int end;

		public Node(int start,int end){
			this.start=start;
			this.end=end;
		}

		public int getStart(){
			return this.start;
		}
		public int getEnd(){
			return this.end;
		}

		@Override
		public int compareTo(Node other){
			if(this.end==other.end){
				return Integer.compare(this.start,other.start);
			}
			return Integer.compare(this.end,other.end);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Node> nodes=new ArrayList<Node>();
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			nodes.add(new Node(start,end));
		}
		Collections.sort(nodes);
		int end=nodes.get(0).getEnd();
		int result=1;
		for(int i=1;i<n;i++){
			int start=nodes.get(i).getStart();
			if(end<=start){
				result+=1;
				end=nodes.get(i).getEnd();
			}
		}

		System.out.print(result);


	}
}
