package software.ulpgc.katas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDB {
    private final String urlDB = "jdbc:sqlite:empleados.db";

    public GestorDB() throws SQLException {
        try(Connection connection = DriverManager.getConnection(urlDB);
            Statement statement = connection.createStatement()){

            String sql = "CREATE TABLE IF NOT EXISTS empleados (nombre TEXT, edad INTEGER, departamento TEXT)";
            statement.execute(sql);

        }
    }

    public void guardarTodos(List<Empleado> empleados) throws SQLException {
        String sql = "INSERT INTO empleados(nombre, edad, departamento) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(urlDB)){
            conn.setAutoCommit(false);

            try (PreparedStatement statement = conn.prepareStatement(sql)){
                for (Empleado empleado : empleados) {
                    statement.setString(1, empleado.nombre());
                    statement.setInt(2, empleado.edad());
                    statement.setString(3, empleado.departamento());
                    statement.executeUpdate();
                }
                conn.commit();
            }
        }
    }

    public List<Empleado> cargarTodos() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection conn = DriverManager.getConnection(urlDB);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                empleados.add(new Empleado(
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getString("departamento")
                ));
            }
        }
        return empleados;
    }
}
