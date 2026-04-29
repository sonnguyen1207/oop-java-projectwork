package fi.oop.model.item;

public class Book extends LibraryItem {

    private final String author;
    private final String isbn;

    public Book(String id, String title, String author, String isbn) {
        super(id, title);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public String getDisplayInfo() {
        return "Title: " + getTitle()
                + "\nAuthor: " + author
                + "\nISBN: " + isbn
                + "\nStatus: " + (isAvailable() ? "Available" : "Borrowed")
                + "\nLoan Period: " + getBorrowingDays() + " days";
    }
}