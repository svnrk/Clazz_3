import java.util.List;

public class Utils {
    public static void printAllStudentList(){
        List<Student> students = Student.getAllStudents();
        for (Student student : students){
            System.out.println(student.getFullName());
        }
    }

    public static void printCourseStudentList(List<Student> students){
        for (Student student : students){
            System.out.println(student.getFullName());
        }
    }
}


