package ar.com.cadoacodo.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;

import ar.com.cadoacodo.dao.DAO;
import ar.com.codoacodo23069.Producto;

/*implemento el contrato = interface DAO 
 *  
 */
public class MysqlDaoImpl implements DAO {
    
    public void createProducto(Producto producto) {
        //ahora armo el sql para hacer un insert

        String sql = "INSERT INTO productos (titulo, autor, precio, imagen, fecha, codigo) VALUES ('', '', 1500, 'blablabla', '2023-07-07 13:32:07', 'aaa000');";
        sql += "()";
        // JDBC
        //connetion: (va a ser entre java y la base de datos)
        //Connection
        // preparedStatment: va a ser una secuencia sql como insert
        //resultSet: va a ser el resultado que se va a dar en forma de tabla
    }

    
    public Producto getById(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    public ArrayList<Producto> findAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    
    public void update(Producto articulo) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
    public void create(Producto articulo) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
}
