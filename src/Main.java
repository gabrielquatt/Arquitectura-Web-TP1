import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Derby.DaoClienteDerby;
import esquema.EsquemaDerby;
import factory.Dao_Factory;
import factory.Derby_DAO_Factory;

public class Main {

	// 1= MySql     2=Derby
	private static int numConection = 2;
	
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Dao_Factory d = Dao_Factory.get_Factory(numConection);
		Connection con = Dao_Factory.get_Conecction(numConection);
		
		//Paso 1: Crear Esquema
		//EsquemaDerby derby = new EsquemaDerby(con);
		//TODO EsquemaMySql = new EsquemaMySql(con)
		
		//Paso 2: Insertar la info de los CSV
		//insertsTables(con,d);
		
		//Consulta 1:
		//d.getDaoProducto().getAll(con);
		String consulta = d.getDaoProducto().masVendido(con);
		System.out.println(consulta);
		
		
	}
	

	private static void insertsTables(Connection conn, Dao_Factory d) throws FileNotFoundException, IOException, SQLException {
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/productos.csv"));
		for (CSVRecord row: parser) {
			d.getDaoProducto().addProduct(conn,Integer.parseInt(row.get("idProducto")),row.get("nombre"),Integer.parseInt(row.get("valor")));
		}
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/clientes.csv"));
		for (CSVRecord row: parser) {
			d.getDaoCliente().addCliente(conn,Integer.parseInt(row.get("idCliente")),row.get("nombre"),row.get("email"));
		}
		
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/facturas.csv"));
		for (CSVRecord row: parser) {
			d.getDaoFactura().addFactura(conn,Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idCliente")));
		}
		
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/facturas-productos.csv"));
		for (CSVRecord row: parser) {
			d.getDaoFacturaProducto().addFacturaProducto(conn,Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idProducto")),Integer.parseInt(row.get("cantidad")));
		}
	}

}
