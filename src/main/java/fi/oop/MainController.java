package fi.oop;

import fi.oop.service.LibraryService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainController {
    @FXML
    private ListView<String> itemListView;

    @FXML
    private Label itemInfoLabel;

    @FXML
    private ComboBox<String> userComboBox;

    @FXML
    private Label userInfoLabel;

    @FXML
    private Label statusLabel;

    private final LibraryService libraryService = new LibraryService();

    @FXML
    public void initialize() {

        // Seed library items
        libraryService.addItem("Php Programming for beginner");
        libraryService.addItem("Python 3 Basics");
        libraryService.addItem("Java Programming Basics");

        // Show items in ListView
        itemListView.getItems().addAll(libraryService.getItems());

        // Seed users
        userComboBox.getItems().addAll(
            "Guest",
            "Student",
            "Staff"
        );
    }

    @FXML
    private void handleUserSelection() {
        statusLabel.setText("User selected");
    }

    @FXML
    private void handleBorrow() {
        String selectedItem = itemListView.getSelectionModel().getSelectedItem();
        String selectedUser = userComboBox.getValue();

        if (selectedItem == null || selectedUser == null) {
            statusLabel.setText("Please select both item and user.");
            return;
        }

        String message = libraryService.borrow(selectedUser, selectedItem);
        statusLabel.setText(message);
    }

    @FXML
    private void handleReturn() {
        String selectedItem = itemListView.getSelectionModel().getSelectedItem();
        String selectedUser = userComboBox.getValue();

        if (selectedItem == null || selectedUser == null) {
            statusLabel.setText("Please select both item and user.");
            return;
        }

        String message = libraryService.returnItem(selectedUser, selectedItem);
        statusLabel.setText(message);
    }
}
