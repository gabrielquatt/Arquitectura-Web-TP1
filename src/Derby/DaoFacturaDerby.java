package Derby;

import dao.DaoFactura;
import factory.Dao_Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFacturaDerby implements DaoFactura {

	@Override
	public void addFactura( int idFactura, int idCliente) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.DERBY_JDBC).getIntance();
		String insert = "INSERT INTO factura (idFactura,idCliente) VALUES (?, ?)";
		java.sql.PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idCliente);
		ps.executeUpdate();
		ps.close();
		c.commit();	
		//c.close();
	}

}
