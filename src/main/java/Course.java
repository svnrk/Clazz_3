import Service.DateMachine;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int output;
    private String name;
    private Integer eap;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String startDateString;
    private String endDateString;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public Course(String name, int eap, String startDateString, String endDateString, Teacher teacher) {
        this.name = name;
        this.eap = eap;
        this.startDate = DateMachine.dateStringToZDT(startDateString);
        this.endDate = DateMachine.dateStringToZDT(endDateString);
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        if (!students.contains(student))
            students.add(student);
            student.addCourse(this);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getEap() {
        return eap;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public Integer getLength() {
        return DateMachine.getPeriodLengthDays(startDate, endDate) + 1;
    }

    public Integer getNumberOfActualWorkDays() {
        DateMachine dateMachine = new DateMachine();
        output = dateMachine.getDiminishedNumberOfWorkDays(startDate, endDate);
        return output;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEap(int eap) {
        this.eap = eap;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDateString) {
        this.startDate = DateMachine.dateStringToZDT(startDateString);
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDateString) {
        this.endDate = DateMachine.dateStringToZDT(endDateString);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
