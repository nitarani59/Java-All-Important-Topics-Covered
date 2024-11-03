package JavaNewDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimePractice {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime  localDateTime2 = LocalDateTime.MAX;
        LocalDateTime  localDateTime3 = LocalDateTime.MIN;
        System.out.println("localDateTime2 " + localDateTime2);
        System.out.println("localDateTime3 " + localDateTime3);
        System.out.println("localDateTime1 " + localDateTime1);
        System.out.println("localDate " + localDate);
        System.out.println("localDateTime " + localDateTime);
    }
}
