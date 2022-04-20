package Derby;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoFacturaProducto;

public class DaoFacturaProductoDerby implements DaoFacturaProducto {

	@Override
	public void addFacturaProducto(Connection c, int idFactura, int idProducto, int cantidad) throws SQLException {
		String insert = "INSERT INTO factura_producto (idFactura,idProducto,cantidad) VALUES (?, ?, ?)";
		java.sql.PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idProducto);
		ps.setInt(3, cantidad);
		ps.executeUpdate();
		//ps.close();
		c.commit();	
	}
  
}
