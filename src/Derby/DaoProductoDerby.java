package Derby;

import dao.DaoProducto;
import factory.Dao_Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoProductoDerby implements DaoProducto {

	@Override
	public void getAll() throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.DERBY_JDBC).getIntance();
		String select = "SELECT * FROM producto";
		PreparedStatement ps = c.prepareStatement(select);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
		}
		//c.close();
	}

	@Override
	public void eliminarProducto() {
		//TODO
	}

	@Override
	public void editarProducto() {
		//TODO
	}

	@Override
	public void addProduct(int id, String name, int value) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.DERBY_JDBC).getIntance();
		String insert = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
		java.sql.PreparedStatement ps = c.prepareStatement(insert);
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
		Connection c = Dao_Factory.get_Factory(Dao_Factory.DERBY_JDBC).getIntance();
		String consulta = "SELECT FP.idProducto, P.nombre "
				+ "FROM factura_producto FP JOIN producto P ON FP.idProducto = P.idProducto "
				+ "GROUP BY FP.idProducto, P.nombre, P.valor " + "ORDER BY SUM(cantidad) * P.valor DESC "
				+ "FETCH FIRST 1 ROWS ONLY";

		java.sql.PreparedStatement ps = c.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();

		String product = "No Se Encontraron Resultados";
		while (rs.next()) {
			product = rs.getInt(1) + ", " + rs.getString(2);
		}
		//c.close();
		return product;
	}
}
