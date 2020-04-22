import java.util.*;

public class Student extends PersonImpl{
    private List<Course> courses;
    private static List<Student> students = new ArrayList<>();

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, String preferredName, String date) {
        super(firstName, lastName, preferredName, date);
        courses = new ArrayList<>();
        if (!students.contains(this)){
            students.add(this);
        }
    }

    @Override
    public void sayHello(){
        System.out.println("Hello student, " + getFullName());
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<String> getTeachers(){
        List<String> teachers = new ArrayList<>();

        for (Course course : courses){
            String teacherName = course.getTeacher().getFullName();
            teachers.add(teacherName);
        }
        return teachers;
    }

    public static List<Student> getAllStudents() {
        return students;
    }
}
