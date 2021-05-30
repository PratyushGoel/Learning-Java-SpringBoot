import java.util.*;
public class Dequeue {
    public static void main(String args[]){
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("A");
        deque.add("B");
        deque.add("C");
        deque.add("D");

        for(String str : deque){
            System.out.println(str);
        }
    }
}
