package ar.com.codoacodo23069;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //crear dos objetos de la clase Producto

        //instanciar un objeto de la clase Producto
        Producto p1 = new Producto("producto1", "autor del producto", 1500.50, "http://bla.com.ar/img.jpg",1);

        //instanciar un objeto de la clase Producto
        Producto p2 = new Producto("producto2", "autor del producto2", 2500.50, "http://bla.com.ar/img2.jpg",2);

        System.out.println(p1);
        System.out.println(p2);
    }
}
