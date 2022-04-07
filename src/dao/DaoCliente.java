package dao;

import java.util.List;
import java.util.Optional;

public interface DaoCliente<T> {
     
    List<T> getAll();
    
    void save(T t);//guardar en la db
    
    void update(T t, String[] params);//actualizar db
    
    void delete(T t); //eliminar de db
}