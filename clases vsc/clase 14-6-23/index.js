//paquete: agrupo clases
package ar.com.codoacodo23069;

//la clase Producto (puede ser como un tipo de dato )
public class Producto {
    
    //atributos
    String imagen;
    double precio;
    String titulo;
    String autor;
    long id;

    //constructor/es
    public Producto(String titulo, String autor, double precio, String imagen, int id) {
        //nace con estos valores
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.imagen = imagen;
        this.id = id;
    }

    //metodos
    String obtenerImagen() {
       return this.imagen;
    }

    void mas10x100() {
        precio = precio * 1.1;
    }
}



package ar.com.codoacodo23069;

public class App 
{
    public static void main( String[] args )
    {
        //crear dos objetos de la clase Producto
        
        //instanciar un objeto de la clase Producto
        Producto p1 = new Producto("producto1","autor del producto",1500.50,"http://bla.com.ar/img.jpg",1);

        //instanciar otro objeto de la clase Producto usanod el constructor de defecto
        Producto p2 = new Producto("producto2","autor del producto2",17500.50,"http://bla.com.ar/img2.jpg",1);

        System.out.println(p1);
        System.out.println(p2);
    }
}