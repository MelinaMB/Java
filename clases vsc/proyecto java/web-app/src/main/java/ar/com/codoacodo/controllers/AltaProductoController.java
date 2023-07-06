package ar.com.codoacodo.controllers;

import ar.com.codoacodo23069.Producto;

public class AltaProductoController {
    //asuminos que es creado por la jvm
    public void doPost(Request Request, Response Response) {

        //asuminmos que aca pegamos parametros desde el formullario
        String titulo = "harry potter"; //request.getTitulo();
        String autor = "autor de harry potter";
        double precio = 1500.5;
        String imagen = "http://bla.com.ar/algo.jpg";

        //ahora nace el producto en la JVM, pero no existe en la DB 
        //no INSERT INTO...
        Producto nuevoProducto = new Producto(titulo, autor, precio, imagen);

        //ahora debo insertar en una base de datos
         

    }
}
