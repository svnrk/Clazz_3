import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

public class Clazz {

    static int counter;
    String name;
    int id;
    ArrayList<Student> students;
    int numOfStudents;


    public Clazz(String name) {
        this.name = name;
        this.id = counter;
        this.students = new ArrayList<Student>();
        this.numOfStudents = this.students.size();
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        this.students.add(student);
        numOfStudents++;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public void printStudentList() {
        for (int i = 0; i<students.size(); i++){
            System.out.print(this.getStudents().get(i).getId() + " ");
            System.out.print(this.getStudents().get(i).getFirstName() + " ");
            System.out.println(this.getStudents().get(i).getLastName());
        }
    }
}
