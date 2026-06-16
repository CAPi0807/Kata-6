package software.ulpgc.katas;

import com.google.gson.Gson;
import java.util.List;
import java.util.stream.Collectors;

public class HistogramAdapter {

    private final HistogramGenerator histogramGenerator = new HistogramGenerator();
    private final Gson gson = new Gson();

    public String adapt(List<Empleado> empleados, String atributo) {
        Histogram histogram;

        switch (atributo.toLowerCase()) {
            case "edad":
                histogram = histogramGenerator.compute(empleados, e -> String.valueOf(e.edad()));
                break;
            case "departamento":
                histogram = histogramGenerator.compute(empleados, Empleado::departamento);
                break;
            default:
                return "error";
        }
        
        return gson.toJson(histogram.keys().stream()
                .collect(Collectors.toMap(
                        key -> key,
                        key -> histogram.valueOf(key)
                )));
    }
}
  
