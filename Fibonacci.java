public class Fibonacci{
    public static boolean test(){
        if(
        fibonacci(0) == 1 && 
        fibonacci(1) == 1 && 
        fibonacci(2) == 2 && 
        fibonacci(3) == 3 && 
        fibonacci(4) == 5 && 
        fibonacci(5) == 8 && 
        fibonacci(6) == 13 
        ) return true;
        else return false;
    }

    public static int fibonacci(int n){
        if(n == 0 || n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}