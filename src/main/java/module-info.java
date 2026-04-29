module fi.oop {
    requires javafx.controls;
    requires javafx.fxml;

    opens fi.oop to javafx.fxml;
    opens fi.oop.model.item to javafx.fxml;
    
    exports fi.oop;
    exports fi.oop.service;
    exports fi.oop.model.item;

}
