import java.util.*;

public class optionals {

    public static void main(String args[]){
        String s = "Hello World!";
        String nullString = null;
        //There is no public constructor thats why we use "of" function and "ofNullable" function
        Optional<String> optionalS1 = Optional.of(s); // Will work
        Optional<String> optionalS2 = Optional.ofNullable(s); // Will work too
//        Optional<String> optionalNull1 = Optional.of(nullString); // -> NullPointerException
        Optional<String> optionalNull2 = Optional.ofNullable(nullString); // Will work

        System.out.println(optionalS1.get()); // prints "Hello World!"
//        System.out.println(optionalNull2.get()); // -> NoSuchElementException
        if(!optionalNull2.isPresent()) {
            System.out.println("Is empty"); // Will be printed
        }

    }

}
