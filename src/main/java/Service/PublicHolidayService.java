package Service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class PublicHolidayService {

    private static final String COUNTRY_CODE = "EE";
    private static final String API_URL = "https://date.nager.at/api/v2/PublicHolidays/";

    public static List<ZonedDateTime> getPublicHolidays(String year) {
        List<ZonedDateTime> result = new ArrayList<>();
        String composedUrl = API_URL + year + "/" + COUNTRY_CODE;

        try {
            URL url = new URL(composedUrl);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                JSONArray array = new JSONArray(inputLine);

                for (Object obj : array) {
                    JSONObject object = (JSONObject) obj;
                    String dateString = object.getString("date");
                    ZonedDateTime holiday = DateMachine.dateStringToZDTOther(dateString, "yyyy-MM-dd");

                    result.add(holiday);
                }
            }
            in.close();
        } catch (Exception ex) {
            System.out.println("häda");
            // alas
        }
        return result;
    }

}