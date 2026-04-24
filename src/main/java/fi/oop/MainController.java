package fi.oop;

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

    @FXML
    private void handleUserSelection() {
        statusLabel.setText("User selected");
    }

    @FXML
    private void handleBorrow() {
        statusLabel.setText("Borrow clicked");
    }

    @FXML
    private void handleReturn() {
        statusLabel.setText("Return clicked");
    }
}
