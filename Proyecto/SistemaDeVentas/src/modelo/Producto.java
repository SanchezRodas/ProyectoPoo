package modelo;

/**
 *
 * @author user
 */
public class Producto {

    //Atributos
    private int idProdcuto;
    private String nombre;
    private int catidad;
    private double precio;
    private String descripcion;
    private int porcentajeIgv;
    private int idCategoria;
    private int estado;
    //Constructor

    public Producto() {
        this.idProdcuto = 0;
        this.nombre = "";
        this.catidad = 0;
        this.precio = 0.0;
        this.descripcion = "";
        this.porcentajeIgv = 0;
        this.idCategoria = 0;
        this.estado = 0;
    }

    //Constructor sobrecargado
    public Producto(int idProdcuto, String nombre, int catidad, double precio, String descripcion, int porcentajeIgv, int idCategoria, int estado) {
        this.idProdcuto = idProdcuto;
        this.nombre = nombre;
        this.catidad = catidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIgv = porcentajeIgv;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }
    //Metodos set & get

    public int getIdProdcuto() {
        return idProdcuto;
    }

    public void setIdProdcuto(int idProdcuto) {
        this.idProdcuto = idProdcuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentajeIgv() {
        return porcentajeIgv;
    }

    public void setPorcentajeIgv(int porcentajeIgv) {
        this.porcentajeIgv = porcentajeIgv;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


}
