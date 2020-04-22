import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;


public class StudentTest {
    Teacher mathTeacher = new Teacher("Math", "Teacher", "Bob", "14-03-1980");
    Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);

    Student dude = new Student("Jeff", "Bridges", "Dude", "19-04-1998");

    @Test
    public void setAndGetCourses() {
        String output = null;
        dude.addCourse(math);
        List<Course> courses = dude.getCourses();
        for (Course course : courses){
            output = course.getName();
        }
        assertEquals(output, "Mathematics 101");
    }


}