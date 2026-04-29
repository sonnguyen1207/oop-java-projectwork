module fi.oop {
    requires javafx.controls;
    requires javafx.fxml;

    opens fi.oop to javafx.fxml;
    opens fi.oop.model.item to javafx.fxml;
    opens fi.oop.model.user to javafx.fxml;

    exports fi.oop;
    exports fi.oop.model.item;
    exports fi.oop.model.user;
    exports fi.oop.service;
}