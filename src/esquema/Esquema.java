package esquema;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import factory.Dao_Factory;

public class Esquema {
	
	public Esquema(Dao_Factory f) throws FileNotFoundException, IOException, SQLException {
		f.createTable();
		insertsTables(f);
	}
	
	private static void insertsTables(Dao_Factory d) throws FileNotFoundException, IOException, SQLException {
		
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/productos.csv"));
		for (CSVRecord row: parser) {
			d.getDaoProducto().addProduct(Integer.parseInt(row.get("idProducto")),row.get("nombre"),Integer.parseInt(row.get("valor")));
		}
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/clientes.csv"));
		for (CSVRecord row: parser) {
			d.getDaoCliente().addCliente(Integer.parseInt(row.get("idCliente")),row.get("nombre"),row.get("email"));
		}
		
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/facturas.csv"));
		for (CSVRecord row: parser) {
			d.getDaoFactura().addFactura(Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idCliente")));
		}
		
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/facturas-productos.csv"));
		for (CSVRecord row: parser) {
			d.getDaoFacturaProducto().addFacturaProducto(Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idProducto")),Integer.parseInt(row.get("cantidad")));
		}
	}
	
}
