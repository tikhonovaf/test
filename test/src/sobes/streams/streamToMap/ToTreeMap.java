package sobes.streams.streamToMap;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class ToTreeMap {
    private static final int RACERS_AMOUNT = 5;
    private static final int LAPS_AMOUNT = 4;
    private static final Random RANDOM = new Random(13331);

    public static void main(String[] args) {
        List<RacerResult> racerResults = new ArrayList<>();
        for (int i = 0; i < RACERS_AMOUNT; i++) {
            List<LocalTime> lapsTime = new ArrayList<>();
            for (int lap = 0; lap < LAPS_AMOUNT; lap++) {
                lapsTime.add(LocalTime.of(0, 2 + RANDOM.nextInt(5), RANDOM.nextInt(60)));
            }
            racerResults.add(new RacerResult("Racer#" + i, lapsTime));
        }
        System.out.println("Best lap: " + findBestLap(racerResults));

        Map<String, Optional<LocalTime>> bestLapsByRacer = calcBestLaps(racerResults);
        System.out.println("Racers time");
        for (Map.Entry<String, Optional<LocalTime>> bestLap : bestLapsByRacer.entrySet()) {
            String racerName = bestLap.getKey();
            LocalTime lapTime = bestLap.getValue().orElseThrow();
            System.out.println(racerName + " | " + lapTime);
        }
    }

    private static LocalTime findBestLap(List<RacerResult> racerResults) {
        return racerResults.stream()
                .flatMap(s-> s.getLapTimes().stream())
                .min(LocalTime::compareTo)
                .get()
                ;
    }

    private static Map<String, Optional<LocalTime>> calcBestLaps(List<RacerResult> racerResults) {
        return racerResults.stream().collect(Collectors.toMap(
                r -> r.getName(),
                r -> r.getLapTimes().stream().min(LocalTime::compareTo),
                (r1, r2 ) -> {throw new RuntimeException("Duplicates value");  },
//                (r1, r2 ) -> ,
                TreeMap::new
        ));
    }

}