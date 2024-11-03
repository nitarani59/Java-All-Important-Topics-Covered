package JavaNewDateTime;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationPractice {
    public static void main(String[] args) {
        Duration duration = Duration.of(1, ChronoUnit.HOURS);
        Duration duration1 = Duration.ofNanos(90);
        Duration duration2 = Duration.ofMillis(9);
        System.out.println("duration2 " + duration2);
        System.out.println("duration1 " + duration1);
        System.out.println("duration " + duration);
    }
}
