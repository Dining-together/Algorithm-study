package 정렬;
import java.util.*;
class 가장_큰_수 {
	public String solution(int[] numbers) {
		String answer = "";
		String[] arr=new String[numbers.length];
		for(int i=0;i<numbers.length;i++){
			arr[i]=numbers[i]+"";
		}
		Arrays.sort(arr,new Comparator<String>(){
			@Override
			public int compare(String n1,String n2){
				return (n2+n1).compareTo(n1+n2);
			}
		});
		for(int i=0;i<numbers.length;i++){
			answer+=arr[i];
		}

		if(answer.charAt(0)=='0'){
			return "0";
		}
		return answer;
	}
}