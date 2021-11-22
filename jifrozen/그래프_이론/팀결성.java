package 그래프_이론;

import java.util.*;

public class 팀결성 {
	public static int n,m;
	public static int[] parent;
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

		for(int i=0;i<=n;i++){
			parent[i]=i;
		}
		for(int i=0;i<m;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			if(a==0){
				union(b,c);
			}else{
				if(findParent(b)==findParent(c)){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}

	}
}
