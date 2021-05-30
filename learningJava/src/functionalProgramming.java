import java.util.*;
import java.util.function.Function;
import java.util.*;
// All variables are supposed to be final
//Methods which take functions as parameters are called as higher order functions

/*
* Storing a function as an Object
* Use java.util.Function<T, R> Interface in Java 8
*T is the argument and R is the Return type
* */

public class functionalProgramming {

    private static Integer invert(Integer value){
        return -value;
    }

    private static Integer compute(Function<Integer,Integer> fx, int x){
        return fx.apply(x);
    }

    public static void main(String args[]){

        Function<Integer,Integer> fx = functionalProgramming::invert;
        Integer x = 10;
        System.out.println(compute(fx, x));
    }
}
