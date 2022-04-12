package factory;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoCliente;
import dao.DaoFactura;
import dao.DaoFacturaProducto;
import dao.DaoProducto;


public interface  Dao_Factory {

	//Atributo de la clase
	public static final int MYSQL_JDBC = 1;
	public static final int DERBY_JDBC = 2;

	static void addPersona(int i, Connection con) {

	}

	public abstract DaoCliente getDaoCliente() throws SQLException;
	public abstract DaoFactura getDaoFactura() throws SQLException;
	public abstract DaoProducto getDaoProducto() throws SQLException;
	public abstract DaoFacturaProducto getDaoFacturaProducto() throws SQLException;

	//Crea un factory especifico segun la tecnologia que se elija.
	static Connection get_DAO_Factory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL_JDBC : return getIntanceMySql();
			case DERBY_JDBC : return getIntanceDerby();
			default: return null;
		}
	}

	private static Connection getIntanceMySql(){
		return Derby_DAO_Factory.getIntance();
	}

	private static  Connection getIntanceDerby(){
		return  Derby_DAO_Factory.getIntance();
	}

}
