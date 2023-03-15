package Controladores;

import clases.Asignatura;
import clases.AsignaturaCombo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class controlador_Profesor1 {

    private controlador_Log_In log_in;
    private Stage stage;

    @FXML
    private TextField apellidosProf;

    @FXML
    private ComboBox<AsignaturaCombo> lista;

    @FXML
    private TextField nombresProf;

    @FXML
    private Button volver;

    public void init(String nombre, String apellido, List<Asignatura> asignaturas, Stage stage, controlador_Log_In controladorLogIn,List<AsignaturaCombo> combo) {
        nombresProf.setText(nombre);
        apellidosProf.setText(apellido);
        this.log_in=controladorLogIn;
        this.stage=stage;
        ObservableList<AsignaturaCombo> listaAsignaturas= FXCollections.observableList(combo);
        lista.getItems().addAll(listaAsignaturas);
    }

    @FXML
    void ir_logIn(ActionEvent event) {
        log_in.show();
        stage.close();

    }

}
