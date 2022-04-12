package dao;

import entidades.Cliente;
import entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface DaoProducto<T> extends Dao<Producto>{

		List<T> getAll();
	    
	    void insertarProducto(T t);//guardar en la db
	    

}
