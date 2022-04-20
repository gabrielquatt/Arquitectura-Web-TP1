package dao;

import entidades.Cliente;
import entidades.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DaoProducto<T> extends Dao<Producto>{

		void getAll(Connection c) throws SQLException;
	    
	    void addProduct(Connection c, int id, String name, int value) throws SQLException;//guardar en la db	  

		void eliminarProducto();

		void editarProducto();
		
		String masVendido(Connection c) throws SQLException;
}
