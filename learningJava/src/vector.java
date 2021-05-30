import java.util.*;

public class vector {
    public static void main(String args[]){
        Vector<String> v = new Vector<String>();
        v.add("ONE");
        v.add("TWO");
        v.add("THREE");

        Iterator it = v.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}