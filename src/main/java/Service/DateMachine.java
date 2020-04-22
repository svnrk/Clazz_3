package Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateMachine {
    public static String dateString;
    public static ZoneId zone1 = ZoneId.of("Europe/Tallinn");
    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static ZonedDateTime dateStringToZDT(String dateString) {
        ZonedDateTime result = null;
        try{
            LocalDate date = LocalDate.parse(dateString, dateFormat);
            result = date.atStartOfDay(zone1);
        }
        catch (Exception e){
            System.out.println("Enter date in format: dd-MM-yyyy");
        }
        return result;
    }

    public static int getPeriodLengthDays(ZonedDateTime startDate, ZonedDateTime endDate){
        return (int) ChronoUnit.DAYS.between(startDate,endDate);
    }

    public static int getPeriodLengthYears(ZonedDateTime startDate, ZonedDateTime endDate){
        return (int) ChronoUnit.YEARS.between(startDate,endDate);
    }

    public static int getAgeInYears(ZonedDateTime dateOfBirth){
        return (int) ChronoUnit.YEARS.between(dateOfBirth,ZonedDateTime.now());
    }
}
