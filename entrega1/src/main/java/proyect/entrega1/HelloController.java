package proyect.entrega1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField nombreClase;
    @FXML
    private TableView<EstudianteTableView> tabla;

    @FXML
    private TableColumn<EstudianteTableView, Integer> columnaId;
    @FXML
    private TableColumn<EstudianteTableView, String> columnaNombre;
    @FXML
    private TableColumn<EstudianteTableView, ArrayList<Nota>> columnaNotas;

    @FXML
    private TextField idcambiar;

    @FXML
    private TextField notaCambiar;


    @FXML
    private TextField indiceMod;

    private ArrayList<Clase> clases;



    private ObservableList<EstudianteTableView> listaEstudiantes = FXCollections.observableArrayList();
    public HelloController() {
    }

    public ArrayList<Clase> archivo() {
        String archivoCSV = "clasesNotas.csv";
        ArrayList<Clase> clases = new ArrayList();

        try {
            File archivo = new File(archivoCSV);
            Scanner scanner = new Scanner(archivo);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while(scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                int idClase = Integer.parseInt(partes[0]);
                int idEstudiante = Integer.parseInt(partes[1]);
                String nombre = partes[2];
                ArrayList<Double> notas= new ArrayList<>();
                for(int i=3;i<partes.length;i++){
                    notas.add(Double.parseDouble(partes[i]));
                }
                Clase claseActual = null;
                Iterator var19 = clases.iterator();

                while(var19.hasNext()) {
                    Clase clase = (Clase)var19.next();
                    if (clase.getIdClase() == idClase) {
                        claseActual = clase;
                        break;
                    }
                }

                if (claseActual == null) {
                    claseActual = new Clase(idClase);
                    clases.add(claseActual);
                }

                Estudiante estudiante = null;
                Iterator var24 = claseActual.getEstudiantes().iterator();

                while(var24.hasNext()) {
                    Estudiante e = (Estudiante)var24.next();
                    if (e.getIdEstudiante() == idEstudiante) {
                        estudiante = e;
                        break;
                    }
                }

                if (estudiante == null) {
                    estudiante = new Estudiante(idEstudiante, nombre, "", new ArrayList());
                    claseActual.agregarEstudiante(estudiante);
                }
                for(int i=0;i<notas.size();i++){
                    estudiante.agregarNota(new Nota(notas.get(i)));
                }
            }

            scanner.close();
        } catch (FileNotFoundException var22) {
            var22.printStackTrace();
        }

        return clases;
    }

    public void actualizarArchivo(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ClasesNotas.csv"));
            writer.write("clase,id,nombre,notas");
            writer.newLine();
            for (Clase clase : clases) {
                for (Estudiante estudiante : clase.getEstudiantes()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(clase.getIdClase());
                    sb.append(",");
                    sb.append(estudiante.getIdEstudiante());
                    sb.append(",");
                    sb.append(estudiante.getNombre());
                    for (Nota nota : estudiante.getNotas()) {
                        sb.append(",");
                        sb.append(nota.getNota());
                    }
                    writer.write(sb.toString());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        clases = this.archivo();
        this.nombreClase.setText("Clase: " + ((Clase)clases.get(0)).getIdClase());
        mostrarDatos(clases.get(0));

    }

    @FXML
    void crear(ActionEvent event) {
        for(int i=0;i<clases.get(0).getEstudiantes().size();i++){
            if(Integer.parseInt(idcambiar.getText())==clases.get(0).getEstudiantes().get(i).getIdEstudiante()){
                Nota nota= new Nota(Double.parseDouble(notaCambiar.getText()));
                clases.get(0).getEstudiantes().get(i).agregarNota(nota);
            }
        }
        listaEstudiantes.clear();
        mostrarDatos(clases.get(0));
        actualizarArchivo();
    }

    @FXML
    void modificar(ActionEvent event) {
        Estudiante est = clases.get(0).buscarEstudiante(Integer.parseInt(idcambiar.getText()));
        Nota not = est.buscarNota(Integer.parseInt(indiceMod.getText())-1);
        not.setNota(Double.parseDouble(notaCambiar.getText()));
        listaEstudiantes.clear();
        mostrarDatos(clases.get(0));
        actualizarArchivo();

    }

    public void mostrarDatos(Clase clas){
        columnaId.setCellValueFactory(new PropertyValueFactory<>("idEstudiante"));

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));

        columnaNotas.setCellValueFactory(new PropertyValueFactory<>("Notas"));

        for (Estudiante estudiante : clas.getEstudiantes()) {
            StringBuilder notasStr = new StringBuilder();
            for (Nota nota : estudiante.getNotas()) {
                notasStr.append(nota.getNota()).append("    ");
            }
            //Eliminamos la última coma y espacio de la cadena de notas
            String notas = notasStr.toString().substring(0, notasStr.length() - 2);
            EstudianteTableView estudianteModel = new EstudianteTableView(estudiante.getIdEstudiante(), estudiante.getNombre(), notas);
            listaEstudiantes.add(estudianteModel);
        }
        tabla.setItems(listaEstudiantes);


    }

}
