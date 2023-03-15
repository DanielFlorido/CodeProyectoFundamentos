package proyect.entrega1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EstudianteTableView {
    private final SimpleIntegerProperty idEstudiante;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty notas;

    public EstudianteTableView(int idEstudiante, String nombre, String notas) {
        this.idEstudiante = new SimpleIntegerProperty(idEstudiante);
        this.nombre = new SimpleStringProperty(nombre);
        this.notas = new SimpleStringProperty(notas);
    }

    public int getIdEstudiante() {
        return idEstudiante.get();
    }

    public SimpleIntegerProperty idEstudianteProperty() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public String getNotas() {
        return notas.get();
    }

    public SimpleStringProperty notasProperty() {
        return notas;
    }
}
