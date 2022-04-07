package factory;

import java.sql.Connection;

import dao.DaoCliente;
import dao.DaoFactura;
import dao.DaoFacturaProducto;
import dao.DaoProducto;


public abstract class Dao_Factory {
	
	public abstract Connection getIntance();
	public abstract DaoCliente getDaoCliente();
	public abstract DaoFactura getDaoFactura();
	public abstract DaoProducto getDaoProducto();
	public abstract DaoFacturaProducto getDaoFacturaProducto();

}
