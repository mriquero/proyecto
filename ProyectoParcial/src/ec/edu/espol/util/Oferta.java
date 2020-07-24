/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

/**
 *
 * @author Mile
 */
public class Oferta {
    //ATRIBUTOS
    private static int numOferta = 0;
    private Comprador comprador;
    private String placaVehiculo;
    private double precioOfertado;
    
    
    //CONSTRUCTORES
    public Oferta() {
    }
    public Oferta(Comprador comprador, Vehiculo vehiculo, double precioOfertado) {
        this.comprador = comprador;
        this.placaVehiculo = vehiculo.getPlaca();
        this.precioOfertado = precioOfertado;
        numOferta = numOferta + 1;
    }
   
    //GETTERS
    public static int getNumOferta() {
        return numOferta;
    }
    public Comprador getComprador() {
        return comprador;
    }
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }
        public double getPrecioOfertado() {
        return precioOfertado;
    }
    
    //SETTERS    **No se aplica Set del numero de Oferta ya que esta es única y no va a variar una vez que se genera
    public void setComprador(Comprador comprador) {
        if (comprador != null)
            this.comprador = comprador;
    }
    public void setPlacaVehiculo(String placaVehiculo) {
        if (placaVehiculo!= null)
            this.placaVehiculo = placaVehiculo;
    }
        public void setPrecioOfertado(double precioOfertado) {
        if (precioOfertado>=0)
            this.precioOfertado = precioOfertado;
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
        
        Oferta other = (Oferta)o;
        return this.numOferta == other.numOferta;
    }
    
    //TOSTRING

    @Override
    public String toString() {
        return "Oferta " + numOferta + "\nCorreo: " + comprador.getCorreo() + "\nPrecio Ofertado: " + precioOfertado;
    }
    
}
