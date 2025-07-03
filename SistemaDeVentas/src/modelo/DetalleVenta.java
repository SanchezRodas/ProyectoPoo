package modelo;

/**
 *
 * @author user
 */
public class DetalleVenta {

    //atributos
    private int idDetalleVenta;
    private int idCabeceraVenta;
    private int idProducto;
    //
    private String nombre;
    private int cantidad;
    private double preciounitario;
    private double subtotal;
    private double descuento;
    private double igv;
    private double totalpagar;
    private int estado;
    //Constructor
    public DetalleVenta (){
        this.idDetalleVenta = 0;
        this.idCabeceraVenta = 0;
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.preciounitario = 0.0;
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.igv = 0.0;
        this.totalpagar = 0.0;
        this.estado = 0;
    }
    //constructor sobrecargadp

    public DetalleVenta(int idDetalleVenta, int idCabeceraVenta, int idProducto, String nombre, int cantidad, double preciounitario, double subtotal, double descuento, double igv, double totalpagar, int estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabeceraVenta = idCabeceraVenta;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.igv = igv;
        this.totalpagar = totalpagar;
        this.estado = estado;
    }
    //gett & sett

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotalpagar() {
        return totalpagar;
    }

    public void setTotalpagar(double totalpagar) {
        this.totalpagar = totalpagar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //to string

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idCabeceraVenta=" + idCabeceraVenta + ", idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", preciounitario=" + preciounitario + ", subtotal=" + subtotal + ", descuento=" + descuento + ", igv=" + igv + ", totalpagar=" + totalpagar + ", estado=" + estado + '}';
    }
    
    
}
