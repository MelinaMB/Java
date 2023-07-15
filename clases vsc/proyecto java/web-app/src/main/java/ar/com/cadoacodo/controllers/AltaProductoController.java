package ar.com.cadoacodo.controllers;

import java.io.IOException;

import ar.com.cadoacodo.dao.DAO;
import ar.com.cadoacodo.dao.impl.MysqlDaoImpl;
import ar.com.codoacodo23069.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AltaProductoController")
public class AltaProductoController extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
        
        //asuminmos que aca pegamos parametros desde el formullario
        String titulo = req.getParameter("nombre"); //request.getTitulo();
        String autor = req.getParameter("autor");
        double precio =Double.parseDouble(req.getParameter("precio"));
        String imagen = req.getParameter("imagen");
        String codigo = req.getParameter("codigo");

        //ahora nace el producto en la JVM, pero no existe en la DB 
        //no INSERT INTO...
        Producto nuevoProducto = new Producto(titulo, autor, precio, imagen, codigo);

        //ahora debo insertar en una base de datos
        //llamar a la implementacion del dao y pasarle el objeto nuevoProducto
        //Interfase i = new claseQueImplementa();
        DAO dao = new MysqlDaoImpl();

        try {
            dao.create(nuevoProducto);
            
            //ahora anda a la vista listado.jsp
            getServletContext().getRequestDispatcher("/ListadoProductosController").forward(req, resp);
            
        } catch (Exception e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("nuevo.jsp").forward(req, resp);
        }
    }
}
