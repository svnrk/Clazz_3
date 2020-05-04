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
//    DateMachine dateMachine = new DateMachine();

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
        Assert.assertEquals(6666, output3);

        int output4 = DateMachine.getPeriodLengthDays(input2, input1);
        Assert.assertEquals(-6666, output4);
    }

    @Test
    public void countsYearsBetweenDates(){
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString3);
        int output3 = DateMachine.getPeriodLengthYears(input1, input2);
        Assert.assertEquals(18, output3);

        int output4 = DateMachine.getPeriodLengthYears(input2, input1);
        Assert.assertEquals(-18, output4);
    }

    @Test
    public void calculatesAge() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString1);
        int output5 = DateMachine.getAgeInYears(input1);
        Assert.assertEquals(18, output5);

        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString4);
        int output6 = DateMachine.getAgeInYears(input2);
        Assert.assertEquals(-9, output6);

    }

    @Test
    public void countsWorkDaysInPeriod() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString5);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString6);
        int output7 = DateMachine.getNumberOfWorkDaysInPeriod(input1, input2);
        Assert.assertEquals(9, output7);

    }

    @Test
    public void makesListOfWorkDaysInPeriod() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString5);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString6);
        List output7 = DateMachine.getWorkDaysInPeriod(input1, input2);
        System.out.println(output7.toString());
        Assert.assertEquals(9, output7.size());

    }


    @Test
    public void crossreferencesListOfHolidaysToListOfWorkDaysInPeriod() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT(dateString7);
        ZonedDateTime input2 = DateMachine.dateStringToZDT(dateString8);
        int output7 = dateMachine.getDiminishedNumberOfWorkDays(input1, input2);
        System.out.println(DateMachine.getWorkDaysInPeriod(input1, input2));
        System.out.println(DateMachine.getNumberOfWorkDaysInPeriod(input1, input2));
        System.out.println(dateMachine.getDiminishedNumberOfWorkDays(input1, input2));
        Assert.assertEquals(15, output7);

    }


    @Mock
    private PublicHolidayService service = new PublicHolidayService();

    @InjectMocks
    private DateMachine dateMachine = new DateMachine();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crossreferencesListOfHolidaysToListOfWorkDaysInPeriodWithMock() {
        ZonedDateTime input1 = DateMachine.dateStringToZDT("15-12-2020");
        ZonedDateTime input2 = DateMachine.dateStringToZDT("18-12-2020");
        ZonedDateTime input3 = DateMachine.dateStringToZDT("16-12-2020");
        List<ZonedDateTime> mock = new ArrayList<>();
        mock.add(input1);
        mock.add(input3);
        when(service.getPublicHolidays("2020")).thenReturn(mock);

        System.out.println(mock.toString());

        int result = dateMachine.getDiminishedNumberOfWorkDays(input1, input2);

        System.out.println(service.getPublicHolidays("2020"));
        System.out.println(DateMachine.getWorkDaysInPeriod(input1, input2));

        Assert.assertEquals(1, result);
    }

//    @Mock
//    private PublicHolidayService service2;
//
//    @InjectMocks
//    private DateMachine mockDateMachine2;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void getListOfHolidaysWithMock() {
//        ZonedDateTime input1 = DateMachine.dateStringToZDT("15-12-2020");
//        ZonedDateTime input2 = DateMachine.dateStringToZDT("18-12-2020");
//        ZonedDateTime input3 = DateMachine.dateStringToZDT("16-12-2020");
//        List<ZonedDateTime> mock = new ArrayList<>();
//        mock.add(input3);
//        when(service2.getPublicHolidays("2020")).thenReturn(mock);
//        System.out.println(mock.toString());
//        System.out.println(service2.getPublicHolidays("2020"));
//        System.out.println(mockDateMachine2.getHolidaysInPeriod(input1, input2));
//        int result = mockDateMachine2.getDiminishedNumberOfWorkDays(input1, input2);
//        Assert.assertEquals(result, 1);
//    }
}
