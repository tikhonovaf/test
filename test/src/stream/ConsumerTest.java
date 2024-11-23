package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream()
                .forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }
}
