import java.util.*;
public class arrayList {
    public static void main(String args[]){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("One");
        arr.add("Two");
        arr.add("Three");

        Iterator itr = arr.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
