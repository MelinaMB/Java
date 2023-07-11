package ar.com.cadoacodo.dao.impl;

import java.sql.Connection;//es una interface de JDBC que esta implementado en el conector=driver=dependencia=artefacto=libreria de mysql
import java.sql.Date;
//que agregamos al pom.xml
import java.sql.PreparedStatement;
import java.util.ArrayList;

import ar.com.cadoacodo.dao.AdministradorDeConexiones;
import ar.com.cadoacodo.dao.DAO;
import ar.com.codoacodo23069.Producto;

/*implemento el contrato = interface DAO 
 *  
 */
public class MysqlDaoImpl implements DAO {
    
    public void create(Producto producto) throws Exception {

        // JDBC
        //connetion: (va a ser entre java y la base de datos)
        Connection connection = AdministradorDeConexiones.getConnection();
        //ahora armo el sql para hacer un insert
        String sql = "INSERT INTO productos (titulo, autor, precio, imagen, fecha, codigo) VALUES (?, ?, ?, ?, ?, ?);";
        // preparedStatment: va a ser una secuencia sql como insert
        PreparedStatement pst = connection.prepareStatement(sql);

        //ahora seteo los valores
        pst.setString(1 , producto.getTitulo());
        pst.setString(2 , producto.getAutor());
        pst.setDouble(3 , producto.getPrecio());
        pst.setString( 4, producto.getImagen());
        pst.setDate( 5, new Date(System.currentTimeMillis()));
        pst.setString( 6, producto.getCodigo ());
        
        //resultSet: va a ser el resultado que se va a dar en forma de tabla
        pst.executeUpdate(); 
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
 
}
