package ar.com.cadoacodo.controllers;

import java.io.IOException;

import ar.com.cadoacodo.dao.DAO;
import ar.com.cadoacodo.dao.impl.MysqlDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarController")
public class EliminarController extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        
        DAO dao = new MysqlDaoImpl();
        
        try {
            dao.delete(Long.parseLong(id));

            //redirect al /ListadoController
            req.setAttribute("aliminadook", "Se ha eliminado el producto id:" + id);

            getServletContext().getRequestDispatcher("/ListadoProductosController").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            
            req.setAttribute("aliminadofail", "Error eliminado el producto id:" + id);

            getServletContext().getRequestDispatcher("/ListadoProductosController").forward(req, resp);
        }
    }
}
