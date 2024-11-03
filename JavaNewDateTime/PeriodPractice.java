package JavaNewDateTime;

import java.time.Period;

public class PeriodPractice {
    public static void main(String[] args) {
        Period period = Period.of(999999,99999,99999);
        Period period1 = Period.ofDays(40);
        Period period2 = Period.ofWeeks(40);
        Period period3 = Period.ofMonths(40);
        Period period4 = Period.ofYears(40);
        Period period5 = Period.ZERO;
        System.out.println("Period5 " + period5);
        System.out.println("Period4 " + period4);
        System.out.println("Period3 " + period3);
        System.out.println("Period2 " + period2);
        System.out.println("Period1 " + period1);
        System.out.println("Period " + period);
    }
}
