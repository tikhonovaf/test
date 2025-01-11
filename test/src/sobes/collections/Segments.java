package sobes.collections;

import java.util.*;
import java.util.stream.Collectors;

public class Segments {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }

        // Подсчитываем частоту каждого символа
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        var orderedCharacters =  s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toList())
;

        // Очередь с приоритетом для сортировки символов по частоте
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder result = new StringBuilder();
        Queue<Character> waitQueue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            char cur1 = orderedCharacters.get(0).getKey();
            result.append(current);
            frequencyMap.put(current, frequencyMap.get(current) - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) {
                continue;
            }

            char front = waitQueue.poll();
            if (frequencyMap.get(front) > 0) {
                maxHeap.offer(front);
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        Segments solution = new Segments();
        String s = "aaabdcccc";
        int k = 3;
        System.out.println(solution.rearrangeString(s, k));  // Пример вывода: "abcabc"
    }
}
