package stream.minexamples;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MinValueTest3 {

    public static void main(String[] args) {

        Person alex = new Person("Alex", 23);
        Person john = new Person("John", 40);
        Person peter = new Person("Peter", 32);
        List<Person> people = Arrays.asList(alex, john, peter);

        // then
        Person minByAge = people
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(minByAge.getName());

    }
}

@AllArgsConstructor
@Getter
class Person {
    String name;
    Integer age;

}