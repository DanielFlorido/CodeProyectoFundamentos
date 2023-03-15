package proyect.entrega1;

import java.util.ArrayList;

class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private ArrayList<Nota> notas;

    public Estudiante(int idEstudiante, String nombre, String apellido, ArrayList<Nota> notas) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = notas;
    }

    public int getIdEstudiante() {
        return this.idEstudiante;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    public Nota buscarNota(int indiceNota) {
        return indiceNota >= 0 && indiceNota < this.notas.size() ? (Nota)this.notas.get(indiceNota) : null;
    }
}

