package clases;

import java.util.ArrayList;

public class Asignatura {
    private int idAsignatura;
    private String nombre;
    private int numCreditos;
    private ArrayList<Clase> clases;

    public Asignatura(int idAsignatura, String nombre, int numCreditos) {
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
        this.numCreditos = numCreditos;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    @Override
    public String toString() {
        return "Asignatura [idAsignatura=" + idAsignatura + ", nombre=" + nombre + ", numCreditos=" + numCreditos +"]";
    }

    public void agregarClase(Clase clase) {
        clases.add(clase);
    }
}
