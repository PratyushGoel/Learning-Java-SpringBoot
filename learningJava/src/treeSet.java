import java.util.*;

//Keeps Sorted order and Unique elements

public class treeSet {
    public static void main(String args[]){
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(2);

        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
