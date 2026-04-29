package fi.oop.service;

import fi.oop.model.item.LibraryItem;
import fi.oop.model.user.LibraryUser;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryService {

    private final List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public List<LibraryItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String borrow(LibraryUser user, LibraryItem item) {

    if (!item.isAvailable()) {
        return item.getTitle() + " is not available.";
    }

    if (!user.canBorrow()) {
        return user.getName() + " has reached the borrow limit.";
    }

    boolean success = user.borrowItem(item);

    if (success) {
        return user.getName() + " borrowed " + item.getTitle()
                + " for " + item.getBorrowingDays() + " days.";
    }

    return "Borrow failed.";
}

    public String returnItem(LibraryUser user, LibraryItem item) {

    boolean success = user.returnItem(item);

    if (success) {
        return user.getName() + " returned " + item.getTitle() + ".";
    }

    return user.getName() + " did not borrow this item.";
}
}