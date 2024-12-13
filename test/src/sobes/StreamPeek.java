package sobes;

import java.util.stream.Stream;

public class StreamPeek {
    public static void main(String[] args) {
        Stream.of(new Phone(1, "1"), new Phone(2, "2"))
                .map(Object::toString)
//                .map(p -> p.toString())
                .peek(System.out::println)
                .peek(System.out::println)
                .filter(s -> s.startsWith("2"))
                .forEach(System.out::println);
    }
}

class Phone {
    private int code;
    private String number;

    public Phone(int code, String number) {
        this.code = code;
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
