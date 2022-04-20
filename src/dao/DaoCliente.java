package dao;

import entidades.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DaoCliente<T> extends Dao<Cliente>{
     
    List<T> masFacturados() throws SQLException;

    void addCliente(Connection con,int id, String nombre, String email ) throws SQLException;

}