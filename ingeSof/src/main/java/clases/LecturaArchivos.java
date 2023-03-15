package clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class LecturaArchivos {

    public static List<Profesor> leerProfesores(String rutaArchivoProfesor , String rutaArchivoAsignatura) throws IOException {
        List<Asignatura> asignaturas = leerAsignaturas(rutaArchivoAsignatura);
        String linea="";
        String separador = ",";
        List<Profesor> profesores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoProfesor))){
            while((linea=br.readLine())!=null){
                String[] datos = linea.split(separador);
                String usuario = datos[0];
                String contrasena = datos[1];
                String nombre = datos[2];
                String apellido = datos[3];

                Profesor profesor = new Profesor(usuario,contrasena,nombre,apellido);
                for(int i=4;i< datos.length;i++){
                    for(Asignatura a: asignaturas){
                        if(a.getIdAsignatura()==Integer.parseInt(datos[i])){
                            int ida=a.getIdAsignatura();
                            String nombrea=a.getNombre();
                            int creditosa=a.getNumCreditos();

                            Asignatura asig = new Asignatura(ida,nombrea,creditosa);
                            profesor.agregarAsignatura(asig);

                        }
                    }
                }

                profesores.add(profesor);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    public static List<Asignatura> leerAsignaturas(String rutaArchivo) throws IOException {
        String linea="";
        String separador = ",";
        List<Asignatura> asignaturas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            while((linea=br.readLine())!=null){
                String[] datos = linea.split(separador);
                int idAsignatura = Integer.parseInt(datos[0].trim());
                String nombre = datos[1].trim();
                int numCreditos = Integer.parseInt(datos[2].trim());

                Asignatura asignatura = new Asignatura(idAsignatura, nombre, numCreditos);
                asignaturas.add(asignatura);

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return asignaturas;
    }

    public static List<Clase> leerClase(String rutaArchivo) throws IOException {
        String linea="";
        String separador = ",";
        List<Clase> clases = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            while((linea=br.readLine())!=null){
                String[] datos = linea.split(separador);
                int idClase = Integer.parseInt(datos[0].trim());
                String nombre = datos[1].trim();

                Clase clas = new Clase(idClase, nombre);
                clases.add(clas);

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return clases;
    }

    public static List<Estudiante> leerEstudiante(String rutaArchivo) throws IOException {
        String linea="";
        String separador = ",";
        List<Estudiante> estudiantes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            while((linea=br.readLine())!=null){
                String[] datos = linea.split(separador);
                int idEstudiante = Integer.parseInt(datos[0].trim());
                String nombre = datos[1].trim();
                String apellido = datos[2].trim();

                Estudiante est = new Estudiante(idEstudiante,nombre,apellido);
                estudiantes.add(est);

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }




}
