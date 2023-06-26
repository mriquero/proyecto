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
        private int vidrios;

    public Auto() {
        super();
    }

    public Auto(String tipoVehiculo, String placa, String marca, String modelo, String motor, int anio, double recorrido, String color, String combustible, String transmision, double precio, int vidrios) {
        super(tipoVehiculo, placa, marca, modelo, motor, anio, recorrido, color, combustible, transmision, precio);
        this.vidrios = vidrios;
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



    public void imprimirVehiculo() {
        System.out.println("**** DATOS DEL VEHICULO ****");
        System.out.println("Tipo de Vehículo: " + this.tipoVehiculo + "\nPlaca: " + this.placa + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nMotor: " + this.motor + "\nAño: " + this.anio + "\nRecorrido: " + this.recorrido + "\nColor: " + this.color + "\nTipo de Combustible: " + this.combustible + "\nTrnasmisión: " + this.transmision + "\nNúmero de Vidrios: " + this.vidrios +"\nPrecio: " + this.precio);
    }
    //TOSTRING
    public String toString() {
        return  tipoVehiculo + "," + placa + "," + marca + "," + modelo + "," + motor + "," + anio + "," + recorrido + "," + color + "," + combustible + "," + transmision + "," + vidrios + "," + precio ;
    }
        // Implementación de los métodos abstractos de Vehiculo
    @Override
    public boolean esTipoVehiculo(String tipo) {
        return tipo.equals(tipoVehiculo);
    }

    @Override
    public boolean esRecorridoValido(double recorrido) {
        // Agregar aquí la lógica específica de validación para los autos
        // Puedes usar el atributo vidrios si es necesario
        // Por ejemplo:
        // return vidrios >= 0 && recorrido >= 0;
        return recorrido >= 0;
    }

}
