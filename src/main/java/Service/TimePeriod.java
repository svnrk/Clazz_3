package Service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TimePeriod {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public TimePeriod(ZonedDateTime startDate, ZonedDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getPeriodLengthDays() {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    public int getPeriodLengthYears() {
        return (int) ChronoUnit.YEARS.between(startDate, endDate);
    }

    public int getNumberOfWorkDaysInPeriod() {
        int counter = 0;
        for (ZonedDateTime day = startDate; day.isBefore(endDate); day.plusDays(1)) {
            int weekday = day.getDayOfWeek().getValue();
            if (weekday < 6) {
                counter++;
            }
            day = day.plusDays(1);
        }
        return counter;
    }

    public List<ZonedDateTime> getWorkDaysInPeriod() {
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

    public int getDiminishedNumberOfWorkDays() {
        List<ZonedDateTime> holidays = new ArrayList<>();
        PublicHolidayService service = new PublicHolidayService();
        int yearStart = startDate.getYear();
        int yearEnd = endDate.getYear();
//        System.out.println(yearStart);
        List<ZonedDateTime> workDays = getWorkDaysInPeriod();
        for (int i = yearStart; i <= yearEnd; i++) {
            holidays.addAll(service.getPublicHolidays(Integer.toString(i)));
        }
        workDays.removeAll(holidays);
        return workDays.size();
    }

    public List<ZonedDateTime> getHolidaysInPeriod() {
        PublicHolidayService service = new PublicHolidayService();
        List<ZonedDateTime> holidays = new ArrayList<>();
        int yearStart = startDate.getYear();
        int yearEnd = endDate.getYear();
        for (int i = yearStart; i <= yearEnd; i++) {
            holidays.addAll(service.getPublicHolidays(Integer.toString(i)));
        }
        holidays.removeIf(holiday -> (holiday.isBefore(startDate)) || (holiday.isAfter(endDate)));

        return holidays;
    }
}
