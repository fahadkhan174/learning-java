package practice;

import java.util.HashSet;
import java.util.Set;

/* given atring and a char, find the greatest distance between
 char occurence neglecting duplicate chars(the given one and other) in between
 */

public class GreatestDistanceBetweenACharacterInString {

    private static int getGreatestDistance(String str, char x) {

        int indexFirst = str.indexOf(x);
        int indexLast = str.lastIndexOf(x);

        Set<Character> set = new HashSet<>();
        char[] array = str.toCharArray();

        for (int i = indexFirst + 1; i < indexLast; i++) {
            if (array[i] != x) {
                set.add(array[i]);
            }
        }

        return set.size();

    }

    public static void main(String[] args) {
        String str = "hello finale h one more h";
        char x = 'h';

        System.out.println(getGreatestDistance(str, x));

    }

}
