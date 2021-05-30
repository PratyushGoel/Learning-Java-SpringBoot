import java.util.*;

public class priorityQueue {
    public static void main(String args[]){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(3);
        queue.add(2);
        queue.add(1);



        System.out.println("head:"+queue.element());
        System.out.println("head:"+queue.peek());

        System.out.println("iterating the queue elements:");
        Iterator<Integer> it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        queue.remove();
        queue.poll();
        System.out.println("After removing 2 elements");
        it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
