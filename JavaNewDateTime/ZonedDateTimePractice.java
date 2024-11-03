package JavaNewDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimePractice {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("zonedDateTime1 " + zonedDateTime1);
        System.out.println("ZonedDateTime " + zonedDateTime);
    }
}
