import java.text.ParseException;

public class School {
    public static void main(String[] args) throws ParseException {

        Student karl = new Student("Karl", "John", "13-10-1990", 0);
        Student peep = new Student("Peep", "Puup", "23-11-1990", 4);

        System.out.println(karl.getId());
        System.out.println(peep.getId());
        System.out.println(karl.getAvgGrade());
        System.out.println(peep.getAvgGrade());
        System.out.println(Student.counter);

        Clazz math = new Clazz("Math");
        Clazz grammar = new Clazz("Grammar");

        grammar.setStudents(karl);
        math.setStudents(karl);
        math.setStudents(peep);
        math.setStudents(peep);
        math.students.add(karl);
//        math.students.add(karl);
//        math.students.add(peep);
//        math.students.add(peep);
        System.out.println(math.getStudents());
        System.out.println("");
        System.out.println(grammar.getNumOfStudents());   // SEE EI TÖÖTA
        grammar.printStudentList();
        System.out.println(math.getNumOfStudents());   // SEE EI TÖÖTA
        math.printStudentList();

        karl.setGrades("math", 3);
        karl.grades.put("grammar", 2.0);
        System.out.println(karl.grades.keys());

    }
}
