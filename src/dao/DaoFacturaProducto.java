package dao;


import java.sql.Connection;
import java.sql.SQLException;

import entidades.Factura_Producto;

public interface DaoFacturaProducto extends Dao<Factura_Producto>{

    void addFacturaProducto(int idFactura, int idProducto,int cantidad) throws SQLException;

}
