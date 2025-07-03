package controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

public class Ctrl_RegistrarVenta {

    //ultimo id de cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal idColVar;

    //Metodo para guardar la cabecera de venta
    public boolean guardar(CabeceraVenta objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cabecera_venta values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPago());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            ResultSet rs = consulta.getGeneratedKeys();
            while (rs.next()) {
                idColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = idColVar.intValue();
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Guardar Cabecera de Venta: " + e);
        }
        return respuesta;
    }

    //Metodo para guardar el detalle de la venta
    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_detalle_venta values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPreciounitario());
            consulta.setDouble(6, objeto.getSubtotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIgv());
            consulta.setDouble(9, objeto.getTotalpagar());
            consulta.setInt(10, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Guardar Detalle de Venta: " + e);
        }
        return respuesta;
    }

    //Implementacion de metodo para actualizar un Producto
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_cabecera_venta set idCliente=?, estado=? "
                    + "where idCabeceraVenta ='" + idCabeceraVenta + "'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera: " + e);
        }
        return respuesta;
    }
}
