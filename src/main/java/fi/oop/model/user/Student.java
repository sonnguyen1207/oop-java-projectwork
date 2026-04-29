package fi.oop.model.user;

public class Student extends LibraryUser {

    private final String studentNumber;

    public Student(String id, String name, String studentNumber) {
        super(id, name);
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public int getBorrowLimit() {
        return 3;
    }

    @Override
    public String getUserType() {
        return "Student";
    }
}