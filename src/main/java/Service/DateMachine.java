package Service;

import java.security.Provider;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateMachine {
    public static String dateString;
    public static ZoneId zone1 = ZoneId.of("Europe/Tallinn");
    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static ZonedDateTime dateStringToZDT(String dateString) {
        ZonedDateTime result = null;
        try {
            LocalDate date = LocalDate.parse(dateString, dateFormat);
            result = date.atStartOfDay(zone1);
        } catch (Exception e) {
            System.out.println("Enter date in format: dd-MM-yyyy");
        }
        return result;
    }

    public static ZonedDateTime dateStringToZDTOther(String dateString, String otherDateFormat) {
        ZonedDateTime result = null;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(otherDateFormat);
        try {
            LocalDate date = LocalDate.parse(dateString, dateFormat);
            result = date.atStartOfDay(zone1);
        } catch (Exception e) {
        }
        return result;
    }

    public static int getPeriodLengthDays(ZonedDateTime startDate, ZonedDateTime endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    public static int getPeriodLengthYears(ZonedDateTime startDate, ZonedDateTime endDate) {
        return (int) ChronoUnit.YEARS.between(startDate, endDate);
    }

    public static int getAgeInYears(ZonedDateTime dateOfBirth) {
        return (int) ChronoUnit.YEARS.between(dateOfBirth, ZonedDateTime.now());
    }

    public static int getNumberOfWorkDaysInPeriod(ZonedDateTime startDate, ZonedDateTime endDate) {
        int counter = 0;
        for (ZonedDateTime day = startDate; day.isBefore(endDate); day.plusDays(1)) {
            int weekday = day.getDayOfWeek().getValue();
            if (weekday < 6) {
                counter++;
//                System.out.println(day);
            }
            day = day.plusDays(1);
        }
        return counter;
    }

    public static List<ZonedDateTime> getWorkDaysInPeriod(ZonedDateTime startDate, ZonedDateTime endDate) {
        List<ZonedDateTime> workDays = new ArrayList<>();
        for (ZonedDateTime day = startDate; day.isBefore(endDate); day.plusDays(1)) {
            int weekday = day.getDayOfWeek().getValue();
            if (weekday < 6) {
                workDays.add(day);
            }
            day = day.plusDays(1);
        }
        return workDays;
    }

    public int getDiminishedNumberOfWorkDays(ZonedDateTime startDate, ZonedDateTime endDate) {
        List<ZonedDateTime> holidays = new ArrayList<>();
        int yearStart = startDate.getYear();
        int yearEnd = endDate.getYear();
//        System.out.println(yearStart);
        List<ZonedDateTime> workDays = getWorkDaysInPeriod(startDate, endDate);
        for (int i = yearStart; i <= yearEnd; i++) {
            holidays.addAll(PublicHolidayService.getPublicHolidays(Integer.toString(i)));
        }
//        System.out.println(workDays);
        workDays.removeAll(holidays);
//        System.out.println(workDays);

        return workDays.size();
    }

}
