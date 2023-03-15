package Controladores;

import clases.AsignaturaCombo;
import clases.Profesor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class controlador_Log_In {

    private Stage stage;

    @FXML
    private PasswordField FieldContra;
    @FXML
    private TextField FieldUser;


    //se puede mejorar pasando a un initialize y creando la estructura comoa tributo.
    @FXML
    void SiguienteVentana(ActionEvent event) throws IOException {
        List<Profesor> profesores = new ArrayList<>();
        clases.LecturaArchivos listaProfesores=new clases.LecturaArchivos();
        profesores=listaProfesores.leerProfesores("profesores.csv","asignaturasingSistemas.csv");
        for(Profesor p: profesores){
            if(p.getUsuario().equals(FieldUser.getText()) && p.getContrasena().equals(FieldContra.getText())){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("profesor.fxml"));
                Parent root = loader.load();
                controlador_Profesor1 controller = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                List<AsignaturaCombo> combo=new ArrayList<>();
                for(clases.Asignatura asignatura: p.getAsignaturas()){
                    AsignaturaCombo comb= new AsignaturaCombo(asignatura.getIdAsignatura(),asignatura.getNombre());
                    combo.add(comb);
                }
                controller.init(p.getNombre(),p.getApellido(),p.getAsignaturas(),stage,this,combo);
                stage.show();
                this.stage.close();
            }//falta hacer el else de si pone algo mal
        }


    }

    public void setStage(Stage stage) {
        this.stage=stage;
    }

    public void show() {
        FieldContra.setText(null);
        FieldUser.setText(null);
        stage.show();
    }
}