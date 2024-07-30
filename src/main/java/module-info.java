module org.uce.app.consultoriomedicodemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.sql;

    opens org.uce.app.consultoriomedicodemo.application to javafx.fxml;
    opens org.uce.app.consultoriomedicodemo.controllers to javafx.fxml;
    opens org.uce.app.consultoriomedicodemo.dao to javafx.fxml;
    opens org.uce.app.consultoriomedicodemo.model to javafx.fxml;
    opens org.uce.app.consultoriomedicodemo.services to javafx.fxml;
    exports org.uce.app.consultoriomedicodemo.application;
}