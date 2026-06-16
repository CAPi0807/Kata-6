package software.ulpgc.katas;

import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Histograma de Empleados");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void mostrarHistograma(Histogram histogram) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key : histogram.keys()){
            dataset.addValue(histogram.valueOf(key), "Frecuencia", key);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma",
                "Categoría",
                "Nº personas",
                dataset
        );

        add(new ChartPanel(chart));
        setVisible(true);
    }
}
