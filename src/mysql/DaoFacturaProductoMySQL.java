package mysql;

import dao.DaoCliente;
import dao.DaoFacturaProducto;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoFacturaProductoMySQL implements DaoFacturaProducto {

	private Connection conn;

	public DaoFacturaProductoMySQL() throws SQLException{

	}

/*	public void insertCSV(CSVParser parser) throws SQLException {
		this.conn = My_SQL_DAO_Factory.createConnection();
		for(CSVRecord row: parser) {
			int id_factura = Integer.parseInt(row.get("idFactura"));
			int id_producto = Integer.parseInt(row.get("idProducto"));
			int cantidad = Integer.parseInt(row.get("cantidad"));

			String insert = "INSERT INTO Factura_Producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, id_factura);
			ps.setInt(2, id_producto);
			ps.setInt(3, cantidad);
			ps.executeUpdate();
			this.conn.commit();
			ps.close();
		}
		this.conn.close();
	}*/
}
