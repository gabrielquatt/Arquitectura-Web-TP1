package mysql;

import dao.DaoFactura;
import dao.DaoProducto;
import factory.Dao_Factory;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoProductoMySQL implements DaoProducto {

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
	public void addProduct( int id, String name, int value) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String insert = "INSERT INTO Producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, value);
		ps.executeUpdate();
		ps.close();
		c.commit();
		//c.close();
	}

	@Override
	public String masVendido() throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String consulta = "SELECT FP.idProducto, P.nombre "
				+ "FROM factura_producto FP JOIN producto P ON FP.idProducto = P.idProducto "
				+ "GROUP BY FP.idProducto, P.nombre, P.valor " + "ORDER BY SUM(cantidad) * P.valor DESC "
				+ "LIMIT 1";

		java.sql.PreparedStatement ps = c.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();

		String product = "No Se Encontraron Resultados";
		while (rs.next()) {
			product = rs.getInt(1) + ", " + rs.getString(2);
		}
		//c.close();
		return product;
	}

	@Override
	public void getAll() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
