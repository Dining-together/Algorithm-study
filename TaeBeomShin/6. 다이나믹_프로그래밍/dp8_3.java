public class dp8_3 {
    public static long[] d= new long[100];

    public static long fibo(int x){
        System.out.print("f("+x+") ");
        if(x==1||x==2){
            return 1;
        }
        if(d[x]!=0){
            return d[x];
        }
        d[x]=fibo(x-1)+fibo(x-2);
        return d[x];
    }
    public static void main(String[] args) {
        fibo(6);
    }
}
