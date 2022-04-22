package dao;

import entidades.Cliente;
import entidades.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DaoProducto<T> extends Dao<Producto>{

		void getAll() throws SQLException;
	    
	    void addProduct( int id, String name, int value) throws SQLException;//guardar en la db	  

		void eliminarProducto();

		void editarProducto();
		
		String masVendido() throws SQLException;
}
