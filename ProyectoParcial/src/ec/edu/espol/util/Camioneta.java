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
public class Camioneta extends Vehiculo{
    //ATRIBUTOS
    private int vidrios;
    
    //CONSTRUCTORES
    public Camioneta() {
    }
    public Camioneta(String tipoVehiculo, String placa, String marca, String modelo, String motor, int anio, double recorrido, String color, String combustible, String transmision, double precio, int vidrios) {
        super(tipoVehiculo, placa, marca, modelo, motor, anio, recorrido, color, combustible, transmision, precio);
        this.vidrios = vidrios;
    }

    Camioneta(String tipo, String placa, String marca, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision, int ventanas) {
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
    
    //TOSTRING
    @Override
    public String toString() {
        return "--- INFORMACIÓN DEL VEHÍCULO ---" + "\nTipo de Vehículo: " + tipoVehiculo + "\nPlaca: " + placa + "\nMarca: " + marca + "\nModelo: " + modelo + "\nTipo de motor: " + motor + "\nAño: " + anio + "\nRecorrido: " + recorrido + " Km \nColor: " + color + "\nTipo combustible: " + combustible + "\nTransmision: " + transmision + "\nNúmero de ventanas: " + vidrios + "\nPrecio: " + precio;
    }

    
}
