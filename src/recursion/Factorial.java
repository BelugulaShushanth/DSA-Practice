package recursion;

public class Factorial {

    public int findFactorial(int n){
        if(n == 0) return 1;
        return n * findFactorial(n-1);
    }
}
