package JavaNewDateTime;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimePractice {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(22,59,22);
        LocalTime localTime2 = LocalTime.ofInstant(Instant.MAX, ZoneId.of("UTC"));
        LocalTime localTime3 = LocalTime.of(20,20);
        System.out.println("localTime3 " + localTime3);
        System.out.println("Instant.MAX " + Instant.MAX);
        System.out.println("localTime2 " + localTime2);
        System.out.println("localTime1 " + localTime1);
        System.out.println("localTime " + localTime);
    }
}
