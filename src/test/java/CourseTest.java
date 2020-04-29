import org.junit.Assert;
import org.junit.Test;

public class CourseTest {
    @Test
    public void returnsCourseLengthInDays() {
        Teacher mathTeacher = new Teacher("Math", "Teacher", "Bob", "14-03-1980");
        Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);

        int output = math.getLength();
        Assert.assertEquals(output, 111);
    }

    @Test
    public void returnsCourseLengthInDaysDiminished() {
        Teacher mathTeacher = new Teacher("Math", "Teacher", "Bob", "14-03-1980");
        Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);

        int output = math.getNumberOfActualWorkDays();
        Assert.assertEquals(output, 79);
    }
}
