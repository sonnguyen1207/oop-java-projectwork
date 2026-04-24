package fi.oop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryService {

    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String borrow(String userName, String item) {
        return userName + " borrowed " + item;
    }

    public String returnItem(String userName, String item) {
        return userName + " returned " + item;
    }
}