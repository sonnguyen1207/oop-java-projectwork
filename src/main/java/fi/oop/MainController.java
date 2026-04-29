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
    private ComboBox<String> userComboBox;

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
                "Guest", "Student", "Staff"));

        itemListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldItem, newItem) -> {
                    if (newItem != null) {
                        itemInfoLabel.setText(newItem.getDisplayInfo());
                    }
                });
    }

    @FXML
    private void handleUserSelection() {
        userInfoLabel.setText("Selected: " + userComboBox.getValue());
    }

    private LibraryUser createUser(String type) {

        if (type.equals("Guest")) {
            return new Guest("U001", "Guest User");
        } else if (type.equals("Student")) {
            return new Student("U002", "Student User", "S1001");
        } else {
            return new Staff("U003", "Staff User", "IT");
        }
    }

    @FXML
    public void handleBorrow() {

        LibraryItem item = itemListView.getSelectionModel().getSelectedItem();
        String selected = userComboBox.getValue();

        if (item == null || selected == null) {
            statusLabel.setText("Select item and user.");
            return;
        }

        LibraryUser user = createUser(selected);

        statusLabel.setText(service.borrow(user, item));

        itemListView.setItems(FXCollections.observableArrayList(service.getItems()));
    }

    @FXML
    public void handleReturn() {

        LibraryItem item = itemListView.getSelectionModel().getSelectedItem();
        String selected = userComboBox.getValue();

        if (item == null || selected == null) {
            statusLabel.setText("Select item and user.");
            return;
        }

        LibraryUser user = createUser(selected);

        statusLabel.setText(service.returnItem(user, item));

        itemListView.setItems(FXCollections.observableArrayList(service.getItems()));
    }
}