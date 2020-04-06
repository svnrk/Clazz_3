import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Student {
    static int counter=0;
    int id;
    String firstName;
    String lastName;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String date;
    Date birthday; // = dateFormat.parse (date);
    float avgGrade;
    Dictionary grades = new Hashtable() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Enumeration keys() {
            return null;
        }

        @Override
        public Enumeration elements() {
            return null;
        }

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public Object put(Object key, Object value) {
            return null;
        }

        @Override
        public Object remove(Object key) {
            return null;
        }
    };

    public Student(String firstName, String lastName, String date, float avgGrade) {
        this.id = counter+1;
        this.firstName = firstName;
        this.lastName = lastName;
        try {this.birthday = dateFormat.parse (date);} catch (ParseException e) {
            e.printStackTrace();
        }
        this.avgGrade = avgGrade;
        counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String date) {
        try {this.birthday = dateFormat.parse (date);} catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(float avgGrade) {
        this.avgGrade = avgGrade;
    }

    public void setGrades(String clazz, float grade){
        this.grades.put(clazz, grade);
    }

    public Dictionary getGrades() {
        return grades;
    }
}
