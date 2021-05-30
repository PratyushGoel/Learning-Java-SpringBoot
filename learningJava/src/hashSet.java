import java.util.*;
public class hashSet {
    public static void main(String args[]){
        HashSet<String> hash = new HashSet<String>();
        hash.add("One");
        hash.add("Two");
        hash.add("Three");

        Iterator<String> itr = hash.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
