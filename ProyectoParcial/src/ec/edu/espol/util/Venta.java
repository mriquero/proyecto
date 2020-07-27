/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
import java.util.Objects;

/**
 *
 * @author Mile
 */
public class Venta {
    //ATRIBUTOS
    private static int iDVenta = 0;              //Variable Autoincrementable con la creación de un nuveo Objeto Venta
    private boolean vendido = false;             //Estado de venta del auto, su estado cambia dentro del método aceptarOferta de la clase Vendedor
    private Vehiculo vehiculo;
    private Vendedor vendedor;
    private Oferta oferta;
    String placaVehiculo;
    
    //CONSTRUCTORES
    public Venta() {
    }
    public Venta(Vehiculo vehiculo, Vendedor vendedor, Oferta oferta) {
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
        this.oferta = oferta;
        iDVenta = iDVenta +1;
    }
    public Venta(String placa, Vendedor vendedor, Oferta oferta) {
        this.placaVehiculo = placa;
        this.vendedor = vendedor;
        this.oferta = oferta;
    }
    
    //GETTERS
    public int getiDVenta(){                                           //No posee setter ya que una vez que se genera la venta no se podría cambiar su identificador para evitar incongruencias en los datos
        return iDVenta;
    }
    public boolean isVendido() {
        return vendido;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public Oferta getOferta() {
        return oferta;
    }
    
    //SETTERS
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo!=null)
            this.vehiculo = vehiculo;
    }
    public void setVendedor(Vendedor vendedor) {
        if (vendedor!=null)
            this.vendedor = vendedor;
    }
    public void setComprador(Oferta oferta) {
        if (oferta!=null)
            this.oferta = oferta;
    }
    
    //EQUALS
    @Override
    public boolean equals(Object o) {
        if (o==null)        
            return false;
        if (this==o)        
            return true;
        if (this.getClass()!= o.getClass())    
            return false;
        Venta other = (Venta)o;
        return this.iDVenta == other.iDVenta;
    }
    
    //TOSTRING

    @Override
    public String toString() {
        if (vendido==true)
            return "***** VENTA EXITOSA ****\n --- Datos de la Venta --- \nVendedor: \n" + vendedor.getNombres() + " " + vendedor.getApellidos() + "\n C.I. " + vendedor.getCedula() + "\nPlaca del vehiculo:  " + placaVehiculo + "\nMonto de la venta: " + oferta.getPrecioOfertado() + "\n\n--- NO ES NECESARIO LA RESPUESTA DE ESTE CORREO ---";
        else
            return "No se ha podido realizar la venta...";
    }
    
    
}
