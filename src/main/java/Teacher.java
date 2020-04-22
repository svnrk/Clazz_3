public class Teacher extends PersonImpl{
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Teacher(String firstName, String lastName, String preferredName, String date) {
        super(firstName, lastName, preferredName, date);
    }
    @Override
    public void sayHello(){
        System.out.println("Hello teacher, " + getFullName());
    }
}
