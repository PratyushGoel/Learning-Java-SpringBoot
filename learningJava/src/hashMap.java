import java.util.*;

//NO duplicate keys

public class hashMap {
    public static void main(String args[]){
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        hash.put("ONE", 1);
        hash.put("TWO", 2);
        hash.put("THREE", 3);

        for(Map.Entry m : hash.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }

        //DELETING KEY BASED ENTRY
        hash.remove("ONE");

        //CHECKING HASHMAP
        System.out.println(hash);

        //REPLACING
        hash.replace("THREE", 33);
        //CHECK SIZE
        System.out.println(hash.size());
        //GET BY KEY
        System.out.println(hash.get("THREE"));

    }
}
