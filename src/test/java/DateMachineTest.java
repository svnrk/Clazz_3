import Service.DateMachine;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;

public class DateMachineTest {
    String dateString1 = "01-10-2001";
    String dateString2 = "01-13-2001";
    String dateString3 = "01-01-2020";
    String dateString4 = "01-01-2030";

    @Test
    public void convertsStringToZDT(){
        ZonedDateTime output = DateMachine.dateStringToZDT(dateString1);
        Assert.assertEquals(output.toString(), "2001-10-01T00:00+02:00[Europe/Tallinn]");

        ZonedDateTime output2 = DateMachine.dateStringToZDT(dateString2);
        Assert.assertNull(output2);
    }

    @Test
    public void countsDaysBetweenDates(){
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString3);
        int output3 = DateMachine.getPeriodLengthDays(input1, input2);
        Assert.assertEquals(output3, 6666);

        int output4 = DateMachine.getPeriodLengthDays(input2, input1);
        Assert.assertEquals(output4, -6666);
    }

    @Test
    public void countsYearsBetweenDates(){
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString3);
        int output3 = DateMachine.getPeriodLengthYears(input1, input2);
        Assert.assertEquals(output3, 18);

        int output4 = DateMachine.getPeriodLengthYears(input2, input1);
        Assert.assertEquals(output4, -18);
    }

    @Test
    public void calculatesAge(){
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        int output5 = DateMachine.getAgeInYears(input1);
        Assert.assertEquals(output5, 18);

        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString4);
        int output6 = DateMachine.getAgeInYears(input2);
        Assert.assertEquals(output6, -9);

    }
}
