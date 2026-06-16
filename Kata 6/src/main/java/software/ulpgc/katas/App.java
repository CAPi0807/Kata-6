package software.ulpgc.katas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static spark.Spark.*;

public class WebService {
    public static void main(String[] args) throws IOException, SQLException {

        System.out.println("Iniciando servicio..");

        GestorDB gdb = new GestorDB();
        List<Empleado> empleados = gdb.cargarTodos();

        port(8080);

        HistogramAdapter adapter = new HistogramAdapter();

        get("/histograma", (request, response) -> {
            response.type("application/json");

            String paramAttr = request.queryParams("atributo");
            if (paramAttr == null) paramAttr = "departamento";

            return adapter.adapt(empleados, paramAttr);
        });

        System.out.println("Servicio listo en http://localhost:8080/histograma?atributo=departamento");
    }
}
