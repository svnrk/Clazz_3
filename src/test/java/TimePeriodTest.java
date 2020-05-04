import Service.DateMachine;
import Service.TimePeriod;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;

public class TimePeriodTest {
    String dateString1 = "01-10-2001";
    String dateString2 = "01-13-2001";
    String dateString3 = "01-01-2020";
    String dateString4 = "01-01-2030";
    String dateString5 = "13-04-2020";
    String dateString6 = "24-04-2020";
    String dateString7 = "15-12-2020";
    String dateString8 = "05-01-2021";

    @Test
    public void countsDaysBetweenDates() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString3);
        TimePeriod timePeriod = new TimePeriod(input1, input2);

        int output3 = timePeriod.getPeriodLengthDays();
        Assert.assertEquals(output3, 6666);

        TimePeriod timePeriod2 = new TimePeriod(input2, input1);
        int output4 = timePeriod2.getPeriodLengthDays();
        Assert.assertEquals(output4, -6666);
    }

    @Test
    public void countsYearsBetweenDates() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString3);
        TimePeriod timePeriod = new TimePeriod(input1, input2);

        int output3 = DateMachine.getPeriodLengthYears(input1, input2);
        Assert.assertEquals(output3, 18);

        TimePeriod timePeriod2 = new TimePeriod(input2, input1);
        int output4 = DateMachine.getPeriodLengthYears(input2, input1);
        Assert.assertEquals(output4, -18);
    }
}
