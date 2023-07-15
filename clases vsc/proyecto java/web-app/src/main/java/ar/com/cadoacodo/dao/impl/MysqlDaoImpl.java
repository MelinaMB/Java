package ar.com.cadoacodo.dao.impl;

import java.sql.Connection;//es una interface de JDBC que esta implementado en el conector=driver=dependencia=artefacto=libreria de mysql
import java.sql.Date;
//que agregamos al pom.xml
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
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
        // connetion: (va a ser entre java y la base de datos)
        Connection connection = AdministradorDeConexiones.getConnection();
        // ahora armo el sql para hacer un insert
        String sql = "INSERT INTO productos (titulo, autor, precio, imagen, fecha, codigo) VALUES (?, ?, ?, ?, ?, ?);";
        // preparedStatment: va a ser una secuencia sql como insert
        PreparedStatement pst = connection.prepareStatement(sql);

        // ahora seteo los valores
        pst.setString(1, producto.getTitulo());
        pst.setString(2, producto.getAutor());
        pst.setDouble(3, producto.getPrecio());
        pst.setString(4, producto.getImagen());
        pst.setDate(5, dateFrom(producto.getFecha()));
        pst.setString(6, producto.getCodigo());

        // resultSet: va a ser el resultado que se va a dar en forma de tabla
        pst.executeUpdate();
    }

    public Producto getById(Long id) throws Exception {

        Connection connection = AdministradorDeConexiones.getConnection();
        String sql = "select * from productos where id = ?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1, id);
        ResultSet res = pst.executeQuery();

        Producto producto = null;

        if (res.next()) {
            Long _id = res.getLong(1);
            String title = res.getString(2);
            String autor = res.getString(3);
            Double precio = res.getDouble(4);
            String imagen = res.getString(5);
            Date fecha = res.getDate(6);
            String codigo = res.getString(7);
            producto = new Producto(_id, title, precio, imagen, fecha.toLocalDate(), codigo, autor);

        }
        return producto;
    }

    public void delete(Long id) throws Exception {
        Connection connection = AdministradorDeConexiones.getConnection();// f5

        String sql = "delete from productos where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setLong(1, id);

        pst.executeUpdate();// insert/update/delete
    }

    @Override
    public ArrayList<Producto> findAll() throws Exception {
        // vamos a ver la clase que viene JDBC
        Connection connection = AdministradorDeConexiones.getConnection();
        // ahora si armo el sql para hacer un INSERT 1 2 3 4 5
        String sql = "select * from productos";
        PreparedStatement pst = connection.prepareStatement(sql);

        ResultSet res = pst.executeQuery();

        ArrayList<Producto> listado = new ArrayList<>();
        // extraer los datos del res!
        while (res.next()) {
            // aca uds hace la magia
            Long id = res.getLong(1);
            String titulo = res.getString(2);
            String autor = res.getString(3);
            double precio = res.getDouble(4);
            String img = res.getString(5);
            Date fecha = res.getDate(6);
            String codigo = res.getString(7);

            listado.add(new Producto(id, titulo, precio, img, fecha.toLocalDate(), codigo, autor));
        }

        return listado;
    }

    private Date dateFrom(LocalDate ldt) {
        java.util.Date date = Date.from(ldt.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new java.sql.Date(date.getTime());
    }

    public void update(Producto producto) throws Exception {

        Connection connection = AdministradorDeConexiones.getConnection();

        String sql = "update productos set titulo = ?, autor = ?, precio = ?, imagen = ? where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setString(1, producto.getTitulo());
        pst.setString(2, producto.getAutor());
        pst.setDouble(3, producto.getPrecio());
        pst.setString(4, producto.getImagen());
        pst.setLong(5, producto.getId());

        pst.executeUpdate();
    }

}
