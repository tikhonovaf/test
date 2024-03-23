package test;

import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        // Creating an empty HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);

        // Getting the value of 25
        System.out.println("The Value is: " + hash_map.get(29));

        // Getting the value of 10
        System.out.println("The Value is: " + hash_map.get(10));
    }

//        try (
//                BufferedReader reader = new BufferedReader(new FileReader("C:\\Temp\\test.txt"));
//                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Temp\\result_my.txt"))
//        ) {
//            String sourceLine;
//            while ((sourceLine = reader.readLine()) != null) {
//                writer.write(sourceLine.replaceAll("[^\\d]", ""));
//                writer.newLine();
//            }
//        }
}
