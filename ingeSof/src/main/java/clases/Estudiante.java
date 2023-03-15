package clases;

import java.util.ArrayList;

public class Estudiante {
    private int idEstudiante;
    private String nombres;
    private String apellidos;
    private ArrayList<Nota> notas;

    public Estudiante(int idEstudiante, String nombres, String apellidos) {
        this.idEstudiante = idEstudiante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        notas = new ArrayList<Nota>();
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    // Métodos getter y setter para los atributos de Estudiante
}
