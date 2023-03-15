module proyect.entrega1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens proyect.entrega1 to javafx.fxml;
    exports proyect.entrega1;
}