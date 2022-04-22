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

	private Derby_DAO_Factory() {
	}
	
	static Dao_Factory getFactory() {
		if(miConector == null) {
			miConector = new Derby_DAO_Factory();
			System.out.println("factory create");
		}
		return miConector;
	}
	
	
	public Connection getIntance() {
		if (conn != null) {
			return conn;
		} else {
			System.out.println("coneccion create");
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
	public DaoCliente getDaoCliente() throws SQLException {
		return new DaoClienteDerby(); //DaoDerbyCliente
	}

	@Override
	public DaoFactura getDaoFactura() throws SQLException {
		return new DaoFacturaDerby();
	}


	@Override
	public DaoProducto getDaoProducto() throws SQLException {
		return new DaoProductoDerby();
	}

	@Override
	public DaoFacturaProducto getDaoFacturaProducto() throws SQLException {
		return new DaoFacturaProductoDerby();
	}

	@Override
	public void createTable() throws SQLException {
		conn = getIntance();
		String table = "CREATE TABLE producto("
				+ "idProducto INT,"
				+ "nombre VARCHAR(500),"
				+ "valor INT,"
				+ "PRIMARY KEY(idProducto))";
		conn.prepareStatement(table).execute();
		conn.commit();

		table = "CREATE TABLE cliente("
				+ "idCliente INT,"
				+ "nombre VARCHAR(500),"
				+ "email VARCHAR(150),"
				+ "PRIMARY KEY(idCliente))";
		conn.prepareStatement(table).execute();
		conn.commit();

		table = "CREATE TABLE factura("
				+ "idFactura INT,"
				+ "idCliente INT,"
				+ "PRIMARY KEY(idFactura),"
				+ "FOREIGN KEY(idCliente) REFERENCES cliente(idCliente))";
		conn.prepareStatement(table).execute();
		conn.commit();

		table = "CREATE TABLE factura_producto("
				+ "idFactura INT,"
				+ "idProducto INT,"
				+ "cantidad INT,"
				//+ "PRIMARY KEY(idFactura,idProducto)"
				+ "FOREIGN KEY(idFactura) REFERENCES factura(idFactura),"
				+ "FOREIGN KEY(idProducto) REFERENCES producto(idProducto))";
		conn.prepareStatement(table).execute();
		conn.commit();
	}

}
