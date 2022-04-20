package Derby;

import dao.DaoFactura;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFacturaDerby implements DaoFactura {

	@Override
	public void addFactura(Connection c, int idFactura, int idCliente) throws SQLException {
		String insert = "INSERT INTO factura (idFactura,idCliente) VALUES (?, ?)";
		java.sql.PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idCliente);
		ps.executeUpdate();
		ps.close();
		c.commit();	
	}

}
