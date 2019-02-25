public class Padjenacci{
    public static boolean test(){
        if(
        padjenacci(1) == 1 && 
        padjenacci(2) == 2 && 
        padjenacci(3) == 3 && 
        padjenacci(4) == 6 && 
        padjenacci(5) == 31 && 
        padjenacci(6) == 934 && 
        padjenacci(7) == 871431
        ) return true;
        else return false;
    }

    public static long padjenacci(long n){
        //Base case
        if(n < 1) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 3;
        
        //Iterative
        return (padjenacci(n-1) * padjenacci(n-1) - padjenacci(n-2) * padjenacci(n-2) + padjenacci(n-3) * padjenacci(n-3));
    }
}