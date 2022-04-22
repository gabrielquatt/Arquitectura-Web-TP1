package Derby;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoFacturaProducto;
import factory.Dao_Factory;

public class DaoFacturaProductoDerby implements DaoFacturaProducto {

	@Override
	public void addFacturaProducto(int idFactura, int idProducto, int cantidad) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.DERBY_JDBC).getIntance();
		String insert = "INSERT INTO factura_producto (idFactura,idProducto,cantidad) VALUES (?, ?, ?)";
		java.sql.PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idProducto);
		ps.setInt(3, cantidad);
		ps.executeUpdate();
		ps.close();
		c.commit();
		//c.close();
	}
  
}
