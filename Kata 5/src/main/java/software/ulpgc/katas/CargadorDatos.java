package software.ulpgc.katas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CargadorDatos {

    public List<Empleado> cargarDesdeCSV(String ruta) throws IOException {
        try (Stream<String> lineas = Files.lines(Paths.get(ruta))) {
            return lineas
                    .map(linea -> linea.split(","))
                    .map(partes -> new Empleado(
                            partes[0].trim(),
                            Integer.parseInt(partes[1].trim()),
                            partes[2].trim()
                    ))
                    .toList();
        }
    }
}
