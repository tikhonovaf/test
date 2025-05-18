package sobes.collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*

1. ƒл€ выполнени€ данной задачи на Java, создадим программу, котора€ будет анализировать файл логов.
2. ѕодсчЄт количества сообщений по видам логов.
3. ѕоиск потока, который больше всего записал данных в байтах.
4. ¬ывод количества логов по видам дл€ найденного потока в пор€дке, заданном пользователем.

 */


public class LogAnalyzer {

    public static void main(String[] args) throws IOException {
        String logFilePath = "C:\\project-education\\test\\test\\files\\log_file.txt"; // «амените на путь к вашему файлу логов

        Map<String, Integer> logTypeCounts = new HashMap<>();
        Map<String, Integer> threadByteCounts = new HashMap<>();
        Map<String, Map<String, Integer>> threadLogCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                String logType = parts[0];
                String threadName = parts[1].substring(parts[1].indexOf('[') + 1, parts[1].indexOf(']'));
                String logText = parts[1].substring(parts[1].indexOf(']') + 2);

                logTypeCounts.put(logType, logTypeCounts.getOrDefault(logType, 0) + 1);
                threadByteCounts.put(threadName, threadByteCounts.getOrDefault(threadName, 0) + logText.getBytes().length);

                threadLogCounts.putIfAbsent(threadName, new HashMap<>());
                Map<String, Integer> threadLogTypeCount = threadLogCounts.get(threadName);
                threadLogTypeCount.put(logType, threadLogTypeCount.getOrDefault(logType, 0) + 1);
            }
        }

        System.out.println("1.  оличество сообщений по видам логов:");
        logTypeCounts.forEach((logType, count) -> System.out.println(logType + ": " + count));

        String maxThread = Collections.max(threadByteCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\n2. ѕоток, который больше всего записал данных в байтах: " + maxThread);

        System.out.println("\n3.  оличество логов по видам дл€ потока " + maxThread + ":");
        Scanner scanner = new Scanner(System.in);
        System.out.println("¬ведите пор€док видов логов, раздел€€ их пробелом (например, error debug info):");
        String[] logOrder = scanner.nextLine().split(" ");

        Map<String, Integer> maxThreadLogCounts = threadLogCounts.get(maxThread);
        for (String logType : logOrder) {
            System.out.println(logType + ": " + maxThreadLogCounts.getOrDefault(logType, 0));
        }
    }
}