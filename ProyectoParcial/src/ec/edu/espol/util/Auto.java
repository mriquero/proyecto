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
public class Auto extends Vehiculo{
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
                //Auto v= new Auto((String)atributos[0],(int)atributos[5],(double)atributos[6],(double)atributos[11]);
                //vehiculos.add(v);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }return vehiculos;
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
    
    //TOSTRING
    @Override
    public String toString() {
        return  tipoVehiculo + "," + placa + "," + marca + "," + modelo + "," + motor + "," + anio + "," + recorrido + "," + color + "," + combustible + "," + transmision + "," + vidrios + "," + precio ;
    }
    
}
