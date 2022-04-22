package mysql;

import dao.Dao;
import dao.DaoCliente;
import factory.Dao_Factory;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class DaoClienteMySQL implements DaoCliente {

	public DaoClienteMySQL() throws SQLException {
	}

	@Override
	public void addCliente(int id, String nombre, String email) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String insert = "INSERT INTO Cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, email);
		ps.executeUpdate();
		ps.close();
		c.commit();
		//c.close();
	}

	@Override
	public HashMap masFacturados() throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		LinkedHashMap<String, Integer> r = new LinkedHashMap<>();
		String consulta = "SELECT C.NOMBRE, SUM(CANTIDAD*VALOR) AS SUMA FROM CLIENTE C "
			    +"JOIN FACTURA F on F.IDCLIENTE_FK = C.IDCLIENTE "
			    +"JOIN FACTURA_PRODUCTO FP on F.IDFACTURA = FP.IDFACTURA "
			    +"JOIN PRODUCTO P on P.IDPRODUCTO = FP.IDPRODUCTO "
			    +"GROUP BY C.IDCLIENTE, C.NOMBRE ORDER BY SUMA DESC";

		java.sql.PreparedStatement ps = c.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			 //System.out.println( rs.getString(1)+"  "+rs.getInt(2));
			 r.put(rs.getString(1),rs.getInt(2));
		}
		imprimirHashMap(r);
		//c.close();
		return r;
	}

	private void imprimirHashMap(LinkedHashMap<String,Integer> r) {
		for (String i : r.keySet()) {
			  System.out.println(i + "     " + r.get(i));
			}
	}
}
