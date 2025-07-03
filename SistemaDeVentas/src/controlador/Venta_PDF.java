package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.InterFacturacion;

/**
 *
 * @author user
 */
public class Venta_PDF {

    private String NombreCliente;
    private String DniCliente;
    private String TelefonoCliente;
    private String DireccionCliente;
    //
    private String FechaActual = "";
    private String NombreArchivoPdfVenta;

    //metodo de obtencio de datos cliente
    public void DatosClientes(int idCliente) {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_cliente where idCliente = '" + idCliente + "'";
        Statement st;
        //
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                DniCliente = rs.getString("dni");
                TelefonoCliente = rs.getString("telefono");
                DireccionCliente = rs.getString("direccion");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos de Cliente" + e);
        }
    }

    //metodo de generar la factura
    public void GenerarFactura() {
        try {
            //carga de fecha actualizada
            Date date = new Date();
            FechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambio de formato
            String fechaNueva = "";
            for (int i = 0; i < FechaActual.length(); i++) {
                if (FechaActual.charAt(i) == '/') {
                    fechaNueva = FechaActual.replace("/", "_");
                }
            }
            NombreArchivoPdfVenta = "Venta_" + NombreCliente + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/PDF/" + NombreArchivoPdfVenta);
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/imagenes/shop.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED);
            fecha.add(Chunk.NEWLINE);//agregar una linea nueva
            fecha.add("Factura 001" + "\nFecha: " + FechaActual + "\n\n");
            //encabezado del pdf
            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);//quitamos borde de tabla
            //tamañano de celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            encabezado.setWidths(ColumnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregamos las celdas
            encabezado.addCell(img);
            String RucEmpresa = "20563468646";
            String NombreEmpresa = "PRODUSANA S.A.C";
            String TelefonoEmpresa = "+51 1 5665559";
            String DireccionEmpresa = "Av. Universitaria 1045, San Miguel 15088";
            String RazonSocialEmpresa = "Alimentacion Saludable";
            //agregamos los datos
            encabezado.addCell("");//una celda vacia de separacion
            encabezado.addCell("RUC: " + RucEmpresa + "\nNombre: " + NombreEmpresa + "\nTelefono: " + TelefonoEmpresa + "\nDireccion: " + DireccionEmpresa + "\nRazon Social: " + RazonSocialEmpresa);
            encabezado.addCell(fecha);
            doc.add(encabezado);
            //adicionamos los datos de Cliente
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del Cliente:" + "\n\n");
            doc.add(cliente);
            //Datos Cliente adicionales
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            //definimos tamaño de celdas
            float[] ColumnaCliente = new float[]{25, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("DNI/RUC: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("NOMBRE: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("TELEFONO: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("DIRECCION: ", negrita));
            //quitamos bordes
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            //agregamos celda a tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(DniCliente);
            tablaCliente.addCell(NombreCliente);
            tablaCliente.addCell(TelefonoCliente);
            tablaCliente.addCell(DireccionCliente);
            //agregamos al pdf
            doc.add(tablaCliente);
            //agregamos un espacio para separar
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            //agregamos productos de compra
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //tamaños de la celda
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("CANTIDAD: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("DESCRIPCION: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("PRECIO UNITARIO: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("PRECIO TOTAL: ", negrita));
            //quitamos borde
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            //damos color
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //agregamos celda a tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            //
            for (int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++) {
                String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_productos.getValueAt(i, 7).toString();
                //
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }
            //agregamos al pdf
            doc.add(tablaProducto);
            //total a pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("TOTAL A PAGAR: " + InterFacturacion.txt_totalpagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            //firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("FIRMA Y PAGO\n\n");
            firma.add("____________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            //agradecimineto
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡GRACIAS POR SU COMPRA!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            //cerramos el documento y archivo
            doc.close();
            archivo.close();
            //abrimos documento en el navegador
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println("Error en:" + e);
        }
    }

}
