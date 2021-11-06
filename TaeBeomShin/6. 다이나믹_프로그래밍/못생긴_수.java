import java.util.Scanner;

import static java.lang.Math.min;

public class 못생긴_수 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        int[] numbers=new int[n+1];

        int idx2=0,idx3=0,idx5=0;
        int next2=2,next3=3,next5=5;

        numbers[0]=1;
        for(int i=1;i<=n;i++){
            numbers[i]=min(min(next2,next3),next5);
            if(numbers[i]==next2){
                idx2++;
                next2=numbers[idx2]*2;
            }
            if(numbers[i]==next3){
                idx3++;
                next3=numbers[idx3]*3;
            }
            if(numbers[i]==next5) {
                idx5++;
                next5 = numbers[idx5] * 5;
            }
        }
        System.out.println(numbers[n-1]);
    }
}
