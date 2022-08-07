package practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SplitStringIntoMapWithStream {
    public static void main(String[] args) {
        String str = "Variable=123,234,456; Currency= INR, USD, GBP; Key=; Name=Fahad";
        System.out.println(Arrays.asList(str.split(";")).stream().map(item -> item.trim().split("="))
                .filter(array -> array.length == 2)
                .collect(Collectors.toMap(e -> e[0], a -> a[1])));
    }
}
