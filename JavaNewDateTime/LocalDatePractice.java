package JavaNewDateTime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDatePractice {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2023/2/1", DateTimeFormatter.ofPattern("yyyy/M/d"));
        LocalDate localDate1 = LocalDate.now(ZoneId.of("UTC"));
        LocalDate localDate2 = LocalDate.ofYearDay(2024, 50);
        LocalDate localDate3 = LocalDate.ofEpochDay(1);
        LocalDate localDate4 = LocalDate.now(Clock.systemDefaultZone());
        System.out.println("localDate4 " + localDate4);
        System.out.println("localDate3 " + localDate3);
        System.out.println("localDate2 " + localDate2);
        System.out.println("localDate1 " + localDate1);
        System.out.println("localDate " + localDate);
    }
}
