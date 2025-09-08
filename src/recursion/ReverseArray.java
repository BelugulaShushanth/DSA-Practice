package recursion;

public class ReverseArray {

    static boolean reverse(String s, int i, int n){
        if(i >= n/2) return true;
        if(s.charAt(i) == s.charAt(n-i-1)) {
            return reverse(s, i+1, n);
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "MADAME";
        System.out.println(reverse(str, 0, str.length()));
    }
}
