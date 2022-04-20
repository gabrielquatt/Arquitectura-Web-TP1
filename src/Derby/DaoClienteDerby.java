package Derby;

import dao.DaoCliente;
import org.apache.commons.csv.CSVParser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DaoClienteDerby implements DaoCliente {

    @Override
    public List masFacturados() throws SQLException {
        return null;
    }

	@Override
	public void addCliente(Connection c, int id, String name, String email) throws SQLException {
		String insert = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
		java.sql.PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.executeUpdate();
		ps.close();
		c.commit();	
	}
}
