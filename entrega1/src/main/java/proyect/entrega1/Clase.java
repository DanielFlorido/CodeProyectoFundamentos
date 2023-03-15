package proyect.entrega1;

import java.util.ArrayList;
import java.util.Iterator;

class Clase {
    private int idClase;
    private ArrayList<Estudiante> estudiantes;

    public Clase(int idClase) {
        this.idClase = idClase;
        this.estudiantes = new ArrayList();
    }

    public int getIdClase() {
        return this.idClase;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return this.estudiantes;
    }

    public Estudiante buscarEstudiante(int idEstudiante) {
        Iterator var2 = this.estudiantes.iterator();

        Estudiante estudiante;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            estudiante = (Estudiante)var2.next();
        } while(estudiante.getIdEstudiante() != idEstudiante);

        return estudiante;
    }
}

