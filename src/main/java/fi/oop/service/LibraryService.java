package fi.oop.service;

import fi.oop.model.item.LibraryItem;
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

    public String borrow(String user, LibraryItem item) {

        if (!item.isAvailable()) {
            return item.getTitle() + " is not available.";
        }

        item.setAvailable(false);
        return user + " borrowed " + item.getTitle()
                + " for " + item.getBorrowingDays() + " days.";
    }

    public String returnItem(String user, LibraryItem item) {

        if (item.isAvailable()) {
            return item.getTitle() + " was not borrowed.";
        }

        item.setAvailable(true);
        return user + " returned " + item.getTitle() + ".";
    }
}