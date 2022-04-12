package mysql;

import dao.DaoCliente;
import dao.DaoFactura;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoFacturaMySQL implements DaoFactura {

	private Connection conn;

	public DaoFacturaMySQL() throws SQLException{

	}


/*
	@Override
	public void insertCSV(CSVParser parser) throws SQLException {
		this.conn = My_SQL_DAO_Factory.createConnection();
		for(CSVRecord row: parser) {
			int id_factura = Integer.parseInt(row.get("idFactura"));
			int id_cliente = Integer.parseInt(row.get("idCliente"));

			String insert = "INSERT INTO Factura (idFactura, idCliente_FK) VALUES (?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, id_factura);
			ps.setInt(2, id_cliente);
			ps.executeUpdate();
			this.conn.commit();
			ps.close();
		}
		this.conn.close();
	}
*/



}
