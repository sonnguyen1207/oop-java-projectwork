package fi.oop.model.item;

public abstract class LibraryItem implements Borrowable{
    private final String id;
    private final String title;
    private boolean available;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        if (available) {
            return "[" + getType() + "] " + title;
        } else {
            return "[" + getType() + "] " + title + " (Borrowed)";
        }
    }

}
