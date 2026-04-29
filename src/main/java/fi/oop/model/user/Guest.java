package fi.oop.model.user;

public class Guest extends LibraryUser {

    public Guest(String id, String name) {
        super(id, name);
    }

    @Override
    public int getBorrowLimit() {
        return 1;
    }

    @Override
    public String getUserType() {
        return "Guest";
    }
}