module com.aerochinquihue {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires com.opencsv;

    opens com.aerochinquihue.controller to javafx.fxml;
    exports com.aerochinquihue;
}
