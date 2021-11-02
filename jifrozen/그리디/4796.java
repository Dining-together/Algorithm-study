package jifrozen.그리디;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int i = 1;
        Scanner sc = new Scanner(System.in);
        while (true) {

            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            int answer = (V / P) * L + Math.min(L, V % P);
            // if(V-(V/P)*P>L && V-(V/P)*P<P){
            // answer+=L;
            // }else{
            // answer+=(V%P);
            // }
            System.out.println("Case " + i + ": " + answer);
            i++;
        }

    }
}
