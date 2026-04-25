module fi.oop {
    requires javafx.controls;
    requires javafx.fxml;

    opens fi.oop to javafx.fxml;
    exports fi.oop;
    exports fi.oop.service;
}
