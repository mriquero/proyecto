/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mile
 */
public class Camion extends Vehiculo implements Busqueda{
    //ATRIBUTOS
    private int vidrios;
    
    //CONSTRUCTORES
    public Camion() {
    }
    public Camion(String tipoVehiculo, String placa, String marca, String modelo, String motor, int anio, double recorrido, String color, String combustible, String transmision, double precio, int vidrios) {
        super(tipoVehiculo, placa, marca, modelo, motor, anio, recorrido, color, combustible, transmision, precio);
        this.vidrios = vidrios;
    }
    
    //GETTERS
    public int getVidrios() {
        return vidrios;
    }
    
    //SETTERS
    public void setVidrios(int vidrios) {
        if (vidrios>=0)
            this.vidrios = vidrios;
    }
    
    
    public void imprimirVehiculo() {
        System.out.println("**** DATOS DEL VEHICULO ****");        
        System.out.println("Tipo de Vehículo: " + this.tipoVehiculo + "\nPlaca: " + this.placa + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nMotor: " + this.motor + "\nAño: " + this.anio + "\nRecorrido: " + this.recorrido + "\nColor: " + this.color + "\nTipo de Combustible: " + this.combustible + "\nTrnasmisión: " + this.transmision + "\nNúmero de Vidrios: " + this.vidrios +"\nPrecio: " + this.precio);
    }
    //TOSTRING
    @Override
    public String toString() {
        return  tipoVehiculo + "," + placa + "," + marca + "," + modelo + "," + motor + "," + anio + "," + recorrido + "," + color + "," + combustible + "," + transmision + "," + vidrios + "," + precio ;
    }

    public Camion(String tipoVehiculo, int anio, double recorrido, double precio) {
        super(tipoVehiculo, anio, recorrido, precio);
    }

    @Override
    public ArrayList<String> Buscar(String Archivo, Vehiculo v1) {
        ArrayList<String> atributos= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(Archivo))){
        while(sc.hasNext()){                         
             String linea= sc.nextLine();             
             String[] arr= linea.split(",");
             String tipo=arr[0];
             String rec=arr[6];
             String anio=arr[7];
             String precio=arr[9];           
             while (v1.getTipoVehiculo().equals(tipo)||v1.getRecorrido()==Double.parseDouble(rec)){
                atributos.add(tipo);
                atributos.add(rec);
                atributos.add(anio);
                atributos.add(precio);
             }
         }   
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
     return atributos;
    }
}
