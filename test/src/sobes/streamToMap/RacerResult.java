package sobes.streamToMap;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

final class RacerResult {
    private String name;
    private List<LocalTime> lapTimes;

    RacerResult(String name, List<LocalTime> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
    }

    public String getName() {
        return name;
    }

    public List<LocalTime> getLapTimes() {
        return lapTimes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RacerResult) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.lapTimes, that.lapTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lapTimes);
    }

    @Override
    public String toString() {
        return "RacerResult[" +
                "name=" + name +
                "lapTimes=" + lapTimes + ']';
    }
}
