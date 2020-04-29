package Service;

public class PublicHoliday {
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private String[] countries;
    private Integer launchYear;
    private String type;

    public PublicHoliday(String date, String localName, String name, String countryCode, boolean fixed, boolean global, String[] countries, Integer launchYear, String type) {
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.fixed = fixed;
        this.global = global;
        this.countries = countries;
        this.launchYear = launchYear;
        this.type = type;
    }
}
