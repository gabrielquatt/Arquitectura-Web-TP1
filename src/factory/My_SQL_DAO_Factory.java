package factory;

import dao.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class My_SQL_DAO_Factory implements Dao_Factory {


    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URI = "jdbc:mysql://localhost:3306/entregable_n1_arquitecturas";
    private static Connection conn;

    public static Connection createConnection() throws SQLException {
        conn = DriverManager.getConnection(URI, "root", "");
        conn.setAutoCommit(false);
        return conn;
    }

    private static void registerDriver() {
        try {
            // Se crea una instancia del Driver utilizando mecanismo de reflexion
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            // Captura fallos al agregar el Driver y sale del programa informando.
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public DaoCliente getDaoCliente() throws SQLException {
        return null;
    }

    @Override
    public DaoFactura getDaoFactura() throws SQLException {
        return null;
    }

    @Override
    public DaoProducto getDaoProducto() throws SQLException {
        return null;
    }

    @Override
    public DaoFacturaProducto getDaoFacturaProducto() throws SQLException {
        return null;
    }

}
