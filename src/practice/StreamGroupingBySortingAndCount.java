package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGroupingBySortingAndCount {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "apple", "apple", "banana", "orange", "orange");

        // groupingby and count
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        // add sorting
        Map<String, Long> orderedMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> orderedMap.put(e.getKey(), e.getValue()));

        System.out.println(orderedMap);

        // sorting and counting objects
        List<Item> items = Arrays.asList(
                new Item("pen", 10, 2),
                new Item("pencil", 5, 3),
                new Item("pen", 10, 2),
                new Item("pen", 10, 2),
                new Item("pencil", 5, 3),
                new Item("paper", 10, 1));

        Map<String, Long> counting = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(counting);

        Map<String, Integer> sum = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println(sum);
    }

}

class Item {
    private String name;
    private int qty;
    private double price;

    public Item(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}