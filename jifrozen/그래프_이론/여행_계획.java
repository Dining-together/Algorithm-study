package 그래프_이론;
import java.util.*;

public class 여행_계획 {
	public static int n,m;
	public static int[] parent=new int[501];
	public static int findParent(int a){
		if(a==parent[a]) return a;
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

		n=sc.nextInt();
		m=sc.nextInt();

		for(int i=1;i<=n;i++){
			parent[i]=i;
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int x=sc.nextInt();
				if(x==1){
					unionParent(i+1,j+1);
				}
			}
		}

		ArrayList<Integer> plan=new ArrayList<>();
		for(int i=0;i<m;i++){
			int x=sc.nextInt();
			plan.add(x);
		}

		boolean result=true;
		for(int i=0;i<m-1;i++){
			if (findParent(plan.get(i)) != findParent(plan.get(i+1))) {
				result=false;
				break;
			}
		}

		if(result) System.out.print("YES");
		else System.out.println("NO");


	}
}
