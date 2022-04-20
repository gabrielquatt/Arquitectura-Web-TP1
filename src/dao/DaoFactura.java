package dao;

import java.sql.Connection;
import java.sql.SQLException;

import entidades.Factura_Producto;

public interface DaoFactura extends Dao<Factura_Producto>{

    void addFactura(Connection con, int idFactura,int idCliente) throws SQLException;


}
