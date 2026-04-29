package fi.oop;

import fi.oop.service.LibraryService;
import fi.oop.model.item.*;
import fi.oop.model.user.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private ListView<LibraryItem> itemListView;

    @FXML
    private Label itemInfoLabel;

    @FXML
    private ComboBox<LibraryUser> userComboBox;

    @FXML
    private Label userInfoLabel;

    @FXML
    private Label statusLabel;

    private final LibraryService service = new LibraryService();

    @FXML
    public void initialize() {

        service.addItem(new Book("B001", "Clean Code", "Robert Martin", "123456"));
        service.addItem(new Book("B002", "Java Basics", "John Smith", "654321"));

        service.addItem(new Magazine("M001", "National Geographic", "NatGeo", 215));
        service.addItem(new Magazine("M002", "Time", "Time Inc", 101));

        itemListView.setItems(FXCollections.observableArrayList(service.getItems()));

        userComboBox.setItems(FXCollections.observableArrayList(
                new Guest("U001", "Alice"),
                new Student("U002", "Bob", "S12345"),
                new Staff("U003", "Emma", "IT")));

        userComboBox.getSelectionModel().selectFirst();

        itemListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldItem, newItem) -> {
                    if (newItem != null) {
                        itemInfoLabel.setText(newItem.getDisplayInfo());
                    }
                });
    }

    @FXML
    private void handleUserSelection() {
        LibraryUser user = userComboBox.getValue();

        if (user == null) {
            userInfoLabel.setText("No user selected.");
            return;
        }

        int borrowed = user.getBorrowedItems().size();
        int limit = user.getBorrowLimit();

        StringBuilder info = new StringBuilder();

        info.append(user.getUserType())
                .append(": ")
                .append(borrowed)
                .append("/")
                .append(limit)
                .append(" borrowed");

        for (LibraryItem item : user.getBorrowedItems()) {
            info.append("\n- ").append(item.getTitle());
        }

        userInfoLabel.setText(info.toString());
    }


    @FXML
    public void handleBorrow() {

        LibraryItem item = itemListView.getSelectionModel().getSelectedItem();
        LibraryUser user = userComboBox.getValue();

        if (item == null || user == null) {
            statusLabel.setText("Select item and user.");
            return;
        }

        statusLabel.setText(service.borrow(user, item));

        itemListView.setItems(FXCollections.observableArrayList(service.getItems()));
        
        refreshItemList(item);
        handleUserSelection();
    }

    @FXML
    public void handleReturn() {

        LibraryItem item = itemListView.getSelectionModel().getSelectedItem();
        LibraryUser user = userComboBox.getValue();

        if (item == null || user == null) {
            statusLabel.setText("Select item and user.");
            return;
        }

        statusLabel.setText(service.returnItem(user, item));

        itemListView.setItems(FXCollections.observableArrayList(service.getItems()));
        
        refreshItemList(item);
        handleUserSelection(); 
    }

    private void refreshItemList(LibraryItem selectedItem) {

        itemListView.setItems(
                FXCollections.observableArrayList(service.getItems()));

        if (selectedItem != null) {
            itemListView.getSelectionModel().select(selectedItem);
        }
    }
}