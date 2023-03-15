package clases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private List<Asignatura> asignaturas;

    public Profesor(String usuario, String contrasena, String nombre, String apellido) throws IOException {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignaturas = new ArrayList<>();


    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    @Override
    public String toString() {
        return "Profesor [usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido="
                + apellido + ", asignaturas=" + /*asignaturas +*/ "]";
    }
}
