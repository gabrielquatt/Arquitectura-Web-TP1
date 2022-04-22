import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Derby.DaoClienteDerby;
import esquema.Esquema;
import factory.Dao_Factory;
import factory.Derby_DAO_Factory;

public class Main {

	// 1= MySql     2=Derby
	private static int numConection = 1;
	
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {	
		Dao_Factory d = Dao_Factory.get_Factory(numConection);
	
		//Esquema e = new Esquema(d);
	
		String consulta = d.getDaoProducto().masVendido();
		System.out.println(consulta);
		
		System.out.println();
		System.out.println();
		d.getDaoCliente().masFacturados();	
	}
	
}
