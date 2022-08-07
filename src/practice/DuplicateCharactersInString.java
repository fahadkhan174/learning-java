package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateCharactersInString {

    public static void main(String[] args) {
        DuplicateCharactersInString obj = new DuplicateCharactersInString();
        System.out.println(obj.getDuplicateChar("hello fahad"));
    }

    private List<Character> getDuplicateChar(String str) {

        List<Character> duplicates = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) != null) {
                int value = map.get(charArray[i]);
                map.put(charArray[i], ++value);
            } else {
                map.put(charArray[i], 1);
            }
        }

        map.forEach((k, v) -> {
            if (v > 1) {
                duplicates.add(k);
            }
        });

        return duplicates;
    }

}
