package ds.hashmap;

public class Demo {

    public static void main(String[] args) {
        HashMapImpl<Integer, String> map = new HashMapImpl<Integer, String>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(2, "A");

        System.out.println(map);
    }

}
