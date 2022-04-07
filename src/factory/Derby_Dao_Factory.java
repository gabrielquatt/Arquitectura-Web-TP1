package factory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.DaoCliente;
import dao.DaoFactura;
import dao.DaoFacturaProducto;
import dao.DaoProducto;

public class Derby_Dao_Factory extends Dao_Factory {
	
	private Connection conn;

	public Derby_Dao_Factory() {
		conn = this.getIntance();
	}

	
	public Connection getIntance() {
		
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DaoFactura getDaoFactura() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DaoProducto getDaoProducto() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DaoFacturaProducto getDaoFacturaProducto() {
		// TODO Auto-generated method stub
		return null;
	}

}
