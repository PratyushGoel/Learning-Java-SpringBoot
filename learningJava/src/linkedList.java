import java.util.*;
public class linkedList {
    public static void main(String args[]){
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);

        Iterator<Integer> itr = ll.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
