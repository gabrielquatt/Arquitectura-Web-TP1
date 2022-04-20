package mysql;

import dao.DaoFactura;
import dao.DaoProducto;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoProductoMySQL implements DaoProducto {

	private Connection conn;

	public DaoProductoMySQL() throws SQLException {
	}

	/*
	 * @Override public void insertCSV(CSVParser parser) throws SQLException {
	 * this.conn = My_SQL_DAO_Factory.createConnection(); for(CSVRecord row: parser)
	 * { int id_producto = Integer.parseInt(row.get("idProducto")); String nombre =
	 * row.get("nombre"); Float valor = Float.parseFloat(row.get("valor"));
	 * 
	 * String insert =
	 * "INSERT INTO Producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
	 * PreparedStatement ps = this.conn.prepareStatement(insert); ps.setInt(1,
	 * id_producto); ps.setString(2, nombre); ps.setFloat(3, valor);
	 * ps.executeUpdate(); this.conn.commit(); ps.close(); } this.conn.close(); }
	 */


	@Override
	public void eliminarProducto() {

	}

	@Override
	public void editarProducto() {

	}

	@Override
	public void addProduct(Connection c, int id, String name, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String masVendido(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAll(Connection c) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
