package mysql;

import dao.DaoCliente;
import dao.DaoFactura;
import factory.Dao_Factory;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoFacturaMySQL implements DaoFactura {

	public DaoFacturaMySQL() throws SQLException{

	}

	@Override
	public void addFactura( int idFactura, int idCliente_FK) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String insert = "INSERT INTO Factura (idFactura, idCliente_FK) VALUES (?, ?)";
		PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idCliente_FK);
		ps.executeUpdate();
		ps.close();
		c.commit();
		//c.close();
	}
}
