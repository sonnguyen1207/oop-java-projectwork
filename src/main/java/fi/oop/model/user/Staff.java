package fi.oop.model.user;

public class Staff extends LibraryUser {

    private final String department;

    public Staff(String id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }

    @Override
    public String getUserType() {
        return "Staff";
    }
}