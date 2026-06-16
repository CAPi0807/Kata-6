package software.ulpgc.katas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, SQLException {

    System.out.println("Descargando remotos...");
    CargadorRemoto cargadorRemoto = new CargadorRemoto();
    String url = "https://gist.githubusercontent.com/CAPi0807/9035f8ca9e83f3d82aac644ae51def2e/raw/b8b803fff524d62b07e11e789fe0305a171c6459/empleados.csv";

    List<Empleado> datosRemotos = cargadorRemoto.cargar(url);

    System.out.println("Guardando en BD...");
    GestorDB gestorDB = new GestorDB();
    gestorDB.guardarTodos(datosRemotos);

    System.out.println("leyendo BD...");
    List<Empleado> empleadosBD = gestorDB.cargarTodos();

    System.out.println("Graficando...");
    HistogramGenerator histogramGenerator = new HistogramGenerator();
    Histogram histogram = histogramGenerator.compute(empleadosBD, Empleado::departamento);

    MainFrame mainFrame = new MainFrame();
    mainFrame.mostrarHistograma(histogram);

    }
}
