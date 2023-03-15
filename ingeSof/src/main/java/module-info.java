module com.example.ingesof {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.opencsv;

    opens Controladores to javafx.fxml;
    exports Controladores;
}