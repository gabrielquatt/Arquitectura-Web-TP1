package mysql;

import dao.Dao;
import dao.DaoCliente;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DaoClienteMySQL implements DaoCliente {

	private Connection conn;

	public DaoClienteMySQL() throws SQLException{
	}

/*
	@Override
	public void insertCSV(CSVParser parser) throws SQLException {
		for(CSVRecord row: parser) {
			int id_cliente = Integer.parseInt(row.get("idCliente"));
			String nombre = row.get("nombre");
			String email = row.get("email");

			String insert = "INSERT INTO Cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, id_cliente);
			ps.setString(2, nombre);
			ps.setString(3, email);
			ps.executeUpdate();
			this.conn.commit();
			ps.close();
		}
		this.conn.close();
	}*/

	@Override
	public List masFacturados() throws SQLException {
		return null;
	}
}
