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
public class Auto extends Vehiculo implements Busqueda{
    //ATIBUTOS
    private int vidrios;           //Número de Vidrios
    
    //CONSTRUCTORES
    public Auto() {
    }
    public Auto(String tipoVehiculo, String placa, String marca, String modelo, String motor, int anio, double recorrido, String color, String combustible, String transmision, double precio, int vidrios) {
        super(tipoVehiculo, placa, marca, modelo, motor, anio, recorrido, color, combustible, transmision, precio);
        this.vidrios = vidrios;
    }

    public Auto(String tipoVehiculo, int anio, double recorrido, double precio) {
        super(tipoVehiculo, anio, recorrido, precio);
    }
    


public static ArrayList<Vehiculo> leerRegistroAutos(String archivo){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try(Scanner sc= new Scanner(new File(archivo))){
            while(sc.hasNextLine()){
                String[] atributos= sc.nextLine().split(",");                
                Auto v;
                v = new Auto(atributos[0],Integer.parseInt(atributos[5]),Integer.parseInt(atributos[6]),Integer.parseInt(atributos[11]));
                vehiculos.add(v);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }return vehiculos;
    }    

    Auto(String tipo, String placa, String marca, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision, int ventanas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public  ArrayList<String> Buscar(String Archivo,Vehiculo v1){
        ArrayList<String> atributos= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(Archivo))){
        while(sc.hasNext()){                         
             String linea= sc.nextLine();             
             String[] arr= linea.split(",");
             String tipo=arr[0];
             String rec=arr[6];
             String anio=arr[7];
             String precio=arr[9];
             //atributos.add(tipo);
             //atributos.add(rec);                         
             /*System.out.println(v1.getTipoVehiculo());
             System.out.println(v1.getTipoVehiculo().equals(tipo));
             System.out.println(v1.getRecorrido());
             System.out.println(v1.getRecorrido()==Double.parseDouble(rec));*/
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

    public void imprimirVehiculo() {
        System.out.println("**** DATOS DEL VEHICULO ****");
        System.out.println("Tipo de Vehículo: " + this.tipoVehiculo + "\nPlaca: " + this.placa + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nMotor: " + this.motor + "\nAño: " + this.anio + "\nRecorrido: " + this.recorrido + "\nColor: " + this.color + "\nTipo de Combustible: " + this.combustible + "\nTrnasmisión: " + this.transmision + "\nNúmero de Vidrios: " + this.vidrios +"\nPrecio: " + this.precio);
    }
    //TOSTRING
    public String toString() {
        return  tipoVehiculo + "," + placa + "," + marca + "," + modelo + "," + motor + "," + anio + "," + recorrido + "," + color + "," + combustible + "," + transmision + "," + vidrios + "," + precio ;
    }
    
}
