/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Mile
 */
public class Oferta {
    //ATRIBUTOS
    private static int numOferta = 0;
    private Comprador comprador;
    private Vehiculo vehiculo;
    private String placaVehiculo;
    private double precioOfertado;
    
    
    //CONSTRUCTORES
    public Oferta() {
    }
    public Oferta(Comprador comprador, Vehiculo vehiculo, double precioOfertado) {
        this.placaVehiculo = vehiculo.getPlaca();
        this.comprador = comprador;
        this.precioOfertado = precioOfertado;
        this.vehiculo = vehiculo;
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
    public Vehiculo getVehiculo() {
        return vehiculo;
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
    public void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo!= null)
            this.vehiculo = vehiculo;
    }
    public void setPrecioOfertado(double precioOfertado) {
        if (precioOfertado>=0)
            this.precioOfertado = precioOfertado;
    }
    
    public void imprimirOferta(int i){
        System.out.println("Oferta " + i);
        System.out.println("Correo: " + this.comprador.getCorreo() + "\nPrecio Ofertado: " + this.precioOfertado);
    }    
    
    public void registrarOferta(String archivo)
    {
        try(FileWriter fw = new FileWriter(archivo,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter addTxt = new PrintWriter(bw))
        {
            addTxt.println(this);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
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
        return placaVehiculo + "," + comprador.getCorreo() + "," + precioOfertado + "," + numOferta;
    }
    
}
