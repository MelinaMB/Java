//paquete agrupo clases
package ar.com.codoacodo23069;

import java.time.LocalDate;//api de fecha de java  

//clase Producto (puede ser un tipo de dato)
public class Producto {
    //atributo, primero va el tipo de dato luego la variable
    private String imagen;
    //datos en decimal en java es double
    private Double precio;
    private String titulo;
    private String autor;
    //long se usa cuando necesito un valor mas ampli que el proporcionado por int
    private long id;
    private LocalDate fecha;
    private String codigo;

    //constructor
    public Producto(String titulo, String autor, double precio, String imagen, int id, String codigo) {
        //el objeto nace con estos valores
        this.id = id;
        init(titulo, autor, precio, imagen, codigo);
    }

    private void init(String titulo, String autor, double precio, String imagen, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.imagen = imagen;
        this.fecha = LocalDate.now(); //fecha de nacimiento
        this.codigo = codigo;
    }

        //sobrecarga: constructor = polimorfismo (constructor con mismo nombre pero con distintos argumentos)
     public Producto(String titulo, String autor, double precio, String imagen, String codigo ) {
        init(titulo, autor, precio, imagen, codigo);
    }

    //metodos, primero va el tipo de dato que devuelve despues va el metodo
    //si en vez de poner string pongo void no se pondria en rojo porque no necesita retornar nada 
    String obtenerImagen() {
        return this.imagen;
    }

    void mas10x100() {
        precio = precio * 1.1;
    }

    public String getImagen() {
        return imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public long getId() {
        return id;
    }

     public String getCodigo() {
        return codigo;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

     public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }
    //no implementamos el setter de feccha ya que no se deberia modificar la fecha de nacimiento

}
