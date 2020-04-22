
import org.junit.Test;

public class UtilsTest {
    Teacher mathTeacher = new Teacher("Math", "Teacher", "Bob", "14-03-1980");
    Student dude = new Student("Jeff", "Bridges", "Dude", "19-04-1998");
    Student dude2 = new Student("John", "Bridges", "Dude", "19-04-1998");
    Student dude3 = new Student("Jane", "Bridges", "Dude", "19-04-1998");
    Student dude4 = new Student("Jane", "Bridges", "Dude", "19-04-1998");
    Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);

    @Test
    public void printsAllStudents(){
        Utils.printAllStudentList();
        System.out.println("All");
    }

    @Test
    public void printsCourseStudents(){

        dude.addCourse(math);
        math.addStudent(dude2);
        Utils.printCourseStudentList(math.getStudents());
    }
}
