package fi.oop.model.user;

import fi.oop.model.item.LibraryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class LibraryUser {

    private final String id;
    private final String name;
    private final List<LibraryItem> borrowedItems = new ArrayList<>();

    public LibraryUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract methods
    public abstract int getBorrowLimit();

    public abstract String getUserType();

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<LibraryItem> getBorrowedItems() {
        return Collections.unmodifiableList(borrowedItems);
    }

    // Concrete methods
    public boolean canBorrow() {
        return borrowedItems.size() < getBorrowLimit();
    }

    public boolean borrowItem(LibraryItem item) {

        if (!canBorrow()) {
            return false;
        }

        if (!item.isAvailable()) {
            return false;
        }

        item.setAvailable(false);
        borrowedItems.add(item);
        return true;
    }

    public boolean returnItem(LibraryItem item) {

        if (borrowedItems.remove(item)) {
            item.setAvailable(true);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return getUserType() + ": " + name +
                " (limit: " + getBorrowLimit() + ")";
    }
}