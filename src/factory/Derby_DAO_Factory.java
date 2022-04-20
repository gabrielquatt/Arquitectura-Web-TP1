package factory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Derby.DaoClienteDerby;
import Derby.DaoFacturaDerby;
import Derby.DaoFacturaProductoDerby;
import Derby.DaoProductoDerby;
import dao.DaoCliente;
import dao.DaoFactura;
import dao.DaoFacturaProducto;
import dao.DaoProducto;

public class Derby_DAO_Factory implements Dao_Factory {
	
	private static Connection conn;
	
	private static  Derby_DAO_Factory miConector;// <== 

	public static Connection getIntance() {
		
		if (conn != null) {
			return conn;
		} else {

			String driver = "org.apache.derby.jdbc.EmbeddedDriver";
			try {
				Class.forName(driver).getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			}

			String uri = "jdbc:derby:myDerbyDB;create=true";

			try {
				conn = DriverManager.getConnection(uri);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;

		}
	}

	@Override
	public DaoCliente getDaoCliente() {
		return new DaoClienteDerby(); //DaoDerbyCliente
	}

	@Override
	public DaoFactura getDaoFactura() throws SQLException {
		return new DaoFacturaDerby();
	}


	@Override
	public DaoProducto getDaoProducto() {
		return new DaoProductoDerby();
	}

	@Override
	public DaoFacturaProducto getDaoFacturaProducto() {
		return new DaoFacturaProductoDerby();
	}

}
