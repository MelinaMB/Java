
package ar.com.codoacodo.controllers;
import java.util.ArrayList;
import java.io.IOException;
import ar.com.cadoacodo.dao.DAO;
import ar.com.cadoacodo.dao.impl.MysqlDaoImpl;
import ar.com.codoacodo23069.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListadoProductosController ")
public class ListadoProductosController  extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
        
    

        //ahora debo insertar en una base de datos
        //llamar a la implementacion del dao y pasarle el objeto nuevoProducto
        //Interfase i = new claseQueImplementa();
        DAO dao = new MysqlDaoImpl();

        try {
            ArrayList<Producto> productos = dao.findAll();

            //guardo en la request los productos
            req.setAttribute("listado", productos);

            //ahora anda a la vista listado.jsp
            req.getRequestDispatcher("listado.jsp").forward(req, resp);//interna!!!
        } catch (Exception e) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
