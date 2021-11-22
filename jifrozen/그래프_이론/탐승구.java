package 그래프_이론;

import java.util.*;

public class 탐승구 {
	public static int[] parent=new int[1000001];
	public static int findParent(int a){
		if(parent[a]==a) return a;
		return parent[a]=findParent(parent[a]);
	}
	public static void unionParent(int a,int b){
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

		int g=sc.nextInt();
		int p=sc.nextInt();

		for(int i=1;i<=g;i++){
			parent[i]=i;
		}

		int result=0;
		for(int i=0;i<p;i++){
			int x=sc.nextInt();
			int root=findParent(x);
			if(root==0) break;
			unionParent(root,root-1);
			result+=1;
		}
		System.out.print(result);
	}
}
