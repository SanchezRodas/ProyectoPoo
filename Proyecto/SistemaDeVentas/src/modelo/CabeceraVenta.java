package modelo;

/**
 *
 * @author user
 */
public class CabeceraVenta {

    //atributos
    private int idCabeceraventa;
    private int idCliente;
    private double valorPago;
    private String fechaVenta;
    private int estado;

    //constructor
    public CabeceraVenta() {
        this.idCabeceraventa = 0;
        this.idCliente = 0;
        this.valorPago = 0.0;
        this.fechaVenta = "";
        this.estado = 0;
    }
    //Contructor sobrecargado

    public CabeceraVenta(int idCabeceraventa, int idCliente, double valorPago, String fechaVenta, int estado) {
        this.idCabeceraventa = idCabeceraventa;
        this.idCliente = idCliente;
        this.valorPago = valorPago;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }
    //gett & sett

    public int getIdCabeceraventa() {
        return idCabeceraventa;
    }

    public void setIdCabeceraventa(int idCabeceraventa) {
        this.idCabeceraventa = idCabeceraventa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    //  to string

    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceraventa=" + idCabeceraventa + ", idCliente=" + idCliente + ", valorPago=" + valorPago + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }
    
}
