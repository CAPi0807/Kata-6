package software.ulpgc.katas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class CargadorRemoto {

    public List<Empleado> cargar(String ruta) throws IOException {
        URL u = new URL(ruta);

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(u.openStream()))){
            return reader.lines()
                    .map(linea -> linea.split(","))
                    .map(partes -> new Empleado(
                            partes[0].trim(),
                            Integer.parseInt(partes[1].trim()),
                            partes[2].trim()
                    ))
                    .collect(Collectors.toList());
        }
    }

}
