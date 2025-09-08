import recursion.Factorial;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Map<String,Integer> map1 = new HashMap<>();
//
//        map1.put("age",25);
//
//        Map<String,Integer> map2 = map1;
//
//        map1.put("age", 23);
//
//        System.out.println(map1+"  "+map1.hashCode());
//        System.out.println(map2+"  "+map2.hashCode());

        String a = "Sushanth";

        String b = a;

        a = "";

        //System.out.println(a+"  "+a.hashCode());
       // System.out.println(b+"  "+b.hashCode());
        System.out.println(new Factorial().findFactorial(5));
    }
}
