import java.util.*;
import java.util.function.BiFunction;

/*

Creating Lambdas
BiFunction class present in java.util

*/

/*
 * For more lines in body of function
 * BiFunction<Integer,Integer,Integer> add = (a, b) -> {
 * Integer ans = a+b;
 * return ans;
 * }
 * */

public class lambdas {

    private static int compute(BiFunction<Integer,Integer,Integer> fx, int x, int y){
        return fx.apply(x,y);
    }

    public static void main(String args[]){
        BiFunction<Integer,Integer,Integer> add = (a, b) -> a+b;
        System.out.println(compute(add, 10, 15));
    }


}
