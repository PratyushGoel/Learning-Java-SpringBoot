import java.util.*;
import java.util.stream.Stream;

public class streams {
    public static void main(String args[]){

        String[] arr = {"Apple", "Banana"};
        HashSet<String> hash = new HashSet<String>();
        LinkedList<Integer> emptyList = new LinkedList<>();

        /*
         * All classes in java collection class can be converted to stream through this method
         * Convert to stream then work then convert back to your data structure
         * */

        Stream<String> arrayStream = Arrays.stream(arr);
        Stream<String> setStream = hash.stream();
        Stream<Integer> listStream = emptyList.stream();

        /*
        * Functions of Streams :
        * 1) .map
        * 2) .forEach // Does'nt return anything hence used in last
        * 3) .flatmap
        *       ex.
        *       List<Integer> numbers1 = Arrays.asList(1, 2, 3);
                List<Integer> numbers2 = Arrays.asList(4, 5, 6);

                Stream.of(numbers1, numbers2) //Stream<List<Integer>>
                    .flatMap(List::stream)  //Stream<Integer>
                    .forEach(System.out::println); // 1 2 3 4 5 6
        * 4) .filter // Takes lambda function that returns boolean as an argument and applies filter on the stream
        * 5) .negate // function called on our lambda function and negates the output
        * 6) .nonNull // gets rid of every null value in stream
        *
        * Converting Stream back to our Data structure
        *
        * 1) .collect // converts to list
               ex. List<Integer> filtered = Stream.of(0, 1, 2, 3)
                  .filter(num -> num < 2)
                  .collect(Collectors.toList());
        *      Collectors.joining(" ") used to make to string and add a delimeter between all of them
        *
        * Shortcuts
        *
        *
        * */

    }
}
