package stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamSeq {

    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<>();
        Integer minAge = 12;
        var room = rooms.stream()
                .filter(r -> r.getPersons().stream()
                        .anyMatch(person -> person.getAge() < minAge)
                )
                .map(Room::getNumber)
                .findFirst();

        final List<String> list = List.of("dog", "cat", "hamster");
        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .sorted()
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
//                .skip(1)
                .forEach(x -> {
                    System.out.println("forEach: " + x);
                });
    }

    @Data
    class Person {
        private String name;
        private int age;
    }

    @Data
    class Room {
        private int number;
        private List<Person> persons;
    }
}
