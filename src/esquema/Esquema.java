package esquema;

import java.sql.Connection;
import java.sql.SQLException;

public class Esquema {

	
	
	private void createTables(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
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
