import Service.DateMachine;
import java.time.*;

public class PersonImpl implements Person{
    private String firstName;
    private String lastName;
    private String fullName;
    private String preferredName;
    private String date;
    private ZonedDateTime dateOfBirth; // = dateFormat.parse (date);

    public PersonImpl(String firstName, String lastName){
        this(firstName, lastName, null, null);
    }

    public PersonImpl(String firstName, String lastName, String preferredName, String date){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.preferredName = preferredName;
        this.dateOfBirth = DateMachine.dateStringToZDT(date);
    }

    public void sayHello(){
        System.out.println("Hello");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAge() {
        return DateMachine.getAgeInYears(dateOfBirth);
    }

}
