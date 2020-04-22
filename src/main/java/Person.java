import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface Person {

    String getFirstName();

    String getFullName();

    String getPreferredName();

    ZonedDateTime getDateOfBirth();

    Integer getAge();

    void sayHello();
}
