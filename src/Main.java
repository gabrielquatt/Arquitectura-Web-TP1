import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoCliente;
import dao.DaoFactura;
import dao.DaoFacturaProducto;
import dao.DaoProducto;
import esquema.EsquemaDerby;
import factory.My_SQL_DAO_Factory;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import factory.Dao_Factory;
import factory.Derby_DAO_Factory;

public class Main {


		public static void Main(String[] args) throws FileNotFoundException, IOException, SQLException {

			Connection con = Dao_Factory.get_DAO_Factory(2);
			EsquemaDerby d = new EsquemaDerby(con);

			//paso 2: Insertar la info de los CSV





		}
		
		
		
		private static void parser(Connection conn) throws FileNotFoundException, IOException, SQLException {

			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/productos.csv"));
			for (CSVRecord row: parser) {
				addProduct(conn,Integer.parseInt(row.get("idProducto")),row.get("nombre"),Integer.parseInt(row.get("valor")));
			}
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/clientes.csv"));
			for (CSVRecord row: parser) {
				addClient(conn,Integer.parseInt(row.get("idCliente")),row.get("nombre"),row.get("email"));
			}
			
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/facturas.csv"));
			for (CSVRecord row: parser) {
				addFactura(conn,Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idCliente")));
			}
			
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/facturas-productos.csv"));
			for (CSVRecord row: parser) {
				addFacturaProducto(conn,Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idProducto")),Integer.parseInt(row.get("cantidad")) );
			}
		}




		
		private static void addProduct(Connection conn, int id, String name, int value) throws SQLException {
			// TODO Auto-generated method stub
			String insert = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, value);
			ps.executeUpdate();
			ps.close();
			conn.commit();
			
		}
		
		private static void addClient(Connection conn, int id, String name, String email) throws SQLException {
			// TODO Auto-generated method stub
			String insert = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.executeUpdate();
			ps.close();
			conn.commit();
			
		}
		
		private static void addFactura(Connection conn, int idFac, int idCli) throws SQLException {
			// TODO Auto-generated method stub
			String insert = "INSERT INTO factura (idFactura,idCliente) VALUES (?, ?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, idFac);
			ps.setInt(2, idCli);

			ps.executeUpdate();
			ps.close();
			conn.commit();
			
		}
		
		private static void addFacturaProducto(Connection conn, int idFac, int idPro, int cant) throws SQLException {
			// TODO Auto-generated method stub
			String insert = "INSERT INTO factura_producto (idFactura,idProducto,cantidad) VALUES (?, ?, ?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, idFac);
			ps.setInt(2, idPro);
			ps.setInt(3, cant);

			ps.executeUpdate();
			ps.close();
			conn.commit();
			
	}

}
