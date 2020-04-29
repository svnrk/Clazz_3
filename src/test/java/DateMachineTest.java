import Service.DateMachine;
import Service.PublicHolidayService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class DateMachineTest {
    String dateString1 = "01-10-2001";
    String dateString2 = "01-13-2001";
    String dateString3 = "01-01-2020";
    String dateString4 = "01-01-2030";
    String dateString5 = "13-04-2020";
    String dateString6 = "24-04-2020";
    String dateString7 = "15-12-2020";
    String dateString8 = "05-01-2021";

    @Test
    public void convertsStringToZDT() {
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
    public void calculatesAge() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        int output5 = DateMachine.getAgeInYears(input1);
        Assert.assertEquals(output5, 18);

        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString4);
        int output6 = DateMachine.getAgeInYears(input2);
        Assert.assertEquals(output6, -9);

    }

    @Test
    public void countsWorkDaysInPeriod() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString5);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString6);
        int output7 = DateMachine.getNumberOfWorkDaysInPeriod(input1, input2);
        Assert.assertEquals(output7, 9);

    }

    @Test
    public void makesListofWorkDaysInPeriod() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString5);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString6);
        List output7 = DateMachine.getWorkDaysInPeriod(input1, input2);
        Assert.assertEquals(output7.size(), 9);

    }

    @Test
    public void crossreferencesListOfHolidaysToListOfWorkDaysInPeriod() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString7);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString8);
        int output7 = DateMachine.getDiminishedNumberOfWorkDays(input1, input2);
        Assert.assertEquals(output7, 12);

    }

    @Mock
    private static PublicHolidayService service = new PublicHolidayService();

    @InjectMocks
    private DateMachine mockDateMachine;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crossreferencesListOfHolidaysToListOfWorkDaysInPeriodWithMock() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString7);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString8);
        List<ZonedDateTime> mock = new ArrayList<>();
        mock.add(input1);
        when(PublicHolidayService.getPublicHolidays("2020")).thenReturn(mock);

        int result = mockDateMachine.getDiminishedNumberOfWorkDays(input1, input2);
        Assert.assertEquals(result, 5);
    }
}
