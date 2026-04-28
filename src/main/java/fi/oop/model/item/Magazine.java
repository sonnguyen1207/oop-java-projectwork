package fi.oop.model.item;

public class Magazine extends LibraryItem {

    private final String publisher;
    private final int issueNumber;

    public Magazine(String id, String title, String publisher, int issueNumber) {
        super(id, title);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public String getDisplayInfo() {
        return "Title: " + getTitle()
                + "\nPublisher: " + publisher
                + "\nIssue Number: " + issueNumber
                + "\nLoan Period: " + getBorrowingDays() + " days";
    }
}