//Unique and maintains Insertion order

import java.util.*;
public class linkedHashSet {
    public static void main(String args[]){
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
