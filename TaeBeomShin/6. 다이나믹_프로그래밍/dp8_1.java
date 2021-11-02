import java.util.Arrays;

public class dp8_1 {
    public static long[]d = new long[100];

    public static long fb(int x){
        if(x==1 || x==2){
            return 1;
        }
        if(d[x]!=0){
            return d[x];
        }
        d[x]=fb(x-1)+fb(x-2);
        return d[x];
    }
    public static void main(String[] args) {
        System.out.println(fb(99));
    }
}
