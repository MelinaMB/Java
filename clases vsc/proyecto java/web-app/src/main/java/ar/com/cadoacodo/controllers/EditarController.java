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

@WebServlet("/EditarController")
public class EditarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DAO dao = new MysqlDaoImpl();

        try {
            Producto producto = dao.getById(Long.parseLong(id));
            req.setAttribute("producto", producto);
            req.getRequestDispatcher("editar.jsp").forward(req, resp);// interna!!!

        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/ListadoProductosController").forward(req, resp);// interna!!!
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // asuminmos que aca pegamos parametros desde el formullario
        Long id = Long.parseLong(req.getParameter("id"));
        String editadoTitulo = req.getParameter("nombre"); // request.getTitulo();
        String editadoAutor = req.getParameter("autor");
        double editadoPrecio = Double.parseDouble(req.getParameter("precio"));
        
        // LocalDate editarFecha = LocalDate.parse(req.getParameter("fecha"));
        // String editadoCodigo = req.getParameter("codigo");

        // ahora nace el producto en la JVM, pero no existe en la DB
        // no INSERT INTO...
        Producto editadoProducto = new Producto(id, editadoTitulo, editadoAutor, editadoPrecio);

        // ahora debo insertar en una base de datos
        // llamar a la implementacion del dao y pasarle el objeto nuevoProducto
        // Interfase i = new claseQueImplementa();
        DAO dao = new MysqlDaoImpl();

        try {
            dao.update(editadoProducto);

            getServletContext().getRequestDispatcher("/ListadoProductosController").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("listado.jsp").forward(req, resp);
        }
    }

}
