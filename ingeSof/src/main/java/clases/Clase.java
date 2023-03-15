package clases;

import java.util.List;
import java.util.ArrayList;

public class Clase {
    private int idClase;
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Clase(int idClase, String nombre) {
        this.idClase = idClase;
        this.nombre = nombre;
        estudiantes = new ArrayList<Estudiante>();
    }

    // Getters y setters
    public int getIdClase() {
        return idClase;
    }
    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

}

