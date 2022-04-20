package Derby;

import dao.DaoCliente;
import org.apache.commons.csv.CSVParser;
import org.apache.derby.tools.sysinfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DaoClienteDerby implements DaoCliente {

 
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

	@Override
	public LinkedHashMap<String, Integer> masFacturados(Connection c) throws SQLException {
		LinkedHashMap<String, Integer> r = new LinkedHashMap<>();
		String consulta = "SELECT C.NOMBRE, SUM(CANTIDAD*VALOR) AS SUMA FROM CLIENTE C "
			    +"JOIN FACTURA F on F.IDCLIENTE = C.IDCLIENTE "
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
		return r;
	}

	private void imprimirHashMap(LinkedHashMap<String,Integer> r) {
		for (String i : r.keySet()) {
			  System.out.println(i + "     " + r.get(i));
			}
	}



	
}
