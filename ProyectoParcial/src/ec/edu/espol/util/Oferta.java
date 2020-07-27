/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
    private String correo;
    private double precioOfertado;
    
    
    //CONSTRUCTORES
    public Oferta() {
    }
    public Oferta(Comprador comprador, Vehiculo vehiculo, double precioOfertado) {
        this.placaVehiculo = vehiculo.getPlaca();
        this.comprador = comprador;
        this.precioOfertado = precioOfertado;
        this.vehiculo = vehiculo;
        this.numOferta = numOferta + 1;
    }
    public Oferta(String placa, String correo, double precioOfertado) {
        this.placaVehiculo = placa;
        this.correo= correo;
        this.precioOfertado = precioOfertado;
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
    public String getCorreo() {
        return correo;
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
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void imprimirOferta(){
        System.out.println("Correo: " + this.correo + "\nPrecio Ofertado: " + this.precioOfertado);
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
   /*public void eliminarOferta(String archivo){
         String placa = this.placaVehiculo;
         ArrayList<String> datos = new ArrayList<>();
         File tipos = new File(archivo);
         
        try(Scanner sc = new Scanner(archivo);
                 FileWriter fw = new FileWriter(archivo,true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw))
        {
             while(sc.hasNextLine())
             {
                 String linea = sc.nextLine();
                 String arr[] = linea.split(",");
                 String plak = arr[0];
                 if(plak != placa)
                 {
                     datos.add(linea);
                 }
             }
             
            archivo.delete();
            for(String linea: datos)
            {
                 out.println(linea);
            }
                   
        }
         
         catch(Exception e)
         {
             System.out.println("No existe esa oferta");
         }
    }*/
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
