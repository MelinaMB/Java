package ar.com.codoacodo23069;

//libro es un (extends) Producto
public class Libro extends Producto{
    //atributos propios
    private String isbn;

    public Libro(String titulo, String autor, double precio, String imagen, int id, String isbn, String codigo) {
        // super = padre
        //cuando uso super() estoy invocando a la clase padre es decir que nace el padre, por lo que ya puede nacer el hijo
        //los parametros tienen que estar en orden como esta en el padre
        super(titulo, autor, precio, imagen, isbn);
        //ahora puede nacer el hijo 
        this.isbn = isbn;
    }
    //el libro no puede nacer, si no nace primero el padre, tambien cuando nace el libro (el hijo) le 
    //puedo pasar parametros que solo puede tener el libro

    //metodos
    public String getIsbn() {
        return this.isbn;
    }
    //si una clase no tiene setter, para sus atributos es una clase inmutable
}
