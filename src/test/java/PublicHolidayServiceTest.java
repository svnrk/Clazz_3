import Service.PublicHolidayService;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PublicHolidayServiceTest {
    PublicHolidayService service = new PublicHolidayService();

    @Test
    public void testURL() {

//        service.getPublicHolidays("2020");
        List output = PublicHolidayService.getPublicHolidays("2020");
        System.out.println(output.toString());
    }

//    @Test
//    public void testDates(){
//        service.getDatesFromString("2020");
//    }
//    @Test
//    public void testDates2() throws IOException {
////        service.getDatesFromString("2020");
//        service.getDates2();
//    }
}
