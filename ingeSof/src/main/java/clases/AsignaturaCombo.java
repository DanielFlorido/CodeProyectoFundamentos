package clases;

public class AsignaturaCombo {
    private int idAsignatura;
    private String nombre;

    public AsignaturaCombo(int idAsignatura,String nombre){
        this.idAsignatura=idAsignatura;
        this.nombre=nombre;
    }
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "codigo de la asignatura: "+idAsignatura + "\n" + nombre;
    }
}
