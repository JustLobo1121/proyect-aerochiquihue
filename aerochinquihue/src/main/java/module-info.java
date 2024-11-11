module com.aerochinquihue {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.aerochinquihue.controller to javafx.fxml;
    exports com.aerochinquihue;
}
