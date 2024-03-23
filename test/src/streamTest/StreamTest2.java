package streamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {
    public void main(String[] args) {

        List<Foo> foos = new ArrayList<>();

//// create foos
//        IntStream
//                .range(1, 4)
//                .forEach(i -> foos.add(new Foo("Foo" + i)));
//
//// create bars
//        foos.forEach(f ->
//                IntStream
//                        .range(1, 4)
//                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
//
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));


//        String[][] dataArray = new String[][]{{"a", "b"},
//                {"c", "d"}, {"e", "f"}, {"g", "h"}};
//
//        List<String> listOfAllChars = Arrays.stream(dataArray)
//                .flatMap(x -> Arrays.stream(x))
//                .collect(Collectors.toList());
//
//        System.out.println(listOfAllChars);

    }


    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }
}


