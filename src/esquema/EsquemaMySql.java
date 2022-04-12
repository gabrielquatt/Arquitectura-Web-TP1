package esquema;

import factory.My_SQL_DAO_Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class EsquemaMySql {

	public void createTable(Connection conn) throws SQLException {
		conn = My_SQL_DAO_Factory.createConnection();
		String tablaFactura = "CREATE TABLE IF NOT EXISTS Factura("
				+ "idFactura INT,"
				+ "idCliente_FK INT,"
				+ "PRIMARY KEY(idFactura),"
				+ "FOREIGN KEY(idCliente_FK) references Cliente(idCliente))";

		conn.prepareStatement(tablaFactura).execute();
		conn.commit();

		String tablaFactura_Producto = "CREATE TABLE IF NOT EXISTS Factura_Producto("
				+ "idFactura INT,"
				+ "idProducto INT,"
				+ "cantidad INT,"
				+ "PRIMARY KEY(idFactura, idProducto),"
				+ "FOREIGN KEY(idFactura) references Factura(idFactura),"
				+ "FOREIGN KEY(idProducto) references Producto(idProducto))";

		conn.prepareStatement(tablaFactura_Producto).execute();
		conn.commit();

		String tablaProducto = "CREATE TABLE IF NOT EXISTS Producto("
				+ "idProducto INT,"
				+ "nombre VARCHAR(45),"
				+ "valor FLOAT,"
				+ "PRIMARY KEY(idProducto))";

		conn.prepareStatement(tablaProducto).execute();
		conn.commit();

		String tablaCliente = "CREATE TABLE IF NOT EXISTS Cliente("
				+ "idCliente INT,"
				+ "nombre VARCHAR(500),"
				+ "email VARCHAR(150),"
				+ "PRIMARY KEY(idCliente))";
		conn.prepareStatement(tablaCliente).execute();
		conn.commit();

		conn.close();
	}

	
}
