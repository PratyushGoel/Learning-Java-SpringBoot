import java.util.*;
public class stack {
    public static void main(String args[]){
        Stack<String> stk = new Stack<String>();
        stk.push("ONE");
        stk.push("TWO");
        stk.push("THREE");

        Iterator<String> itr = stk.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        itr = stk.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
