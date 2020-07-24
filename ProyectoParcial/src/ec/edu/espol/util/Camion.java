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
public class Camion extends Vehiculo{
    //ATRIBUTOS
    private int vidrios;
    
    //CONSTRUCTORES
    public Camion() {
    }
    public Camion(String tipoVehiculo, String placa, String marca, String motor, int anio, double recorrido, String color, String combustible, double precio, String transmision, int vidrios) {
        super(tipoVehiculo, placa, marca, motor, anio, recorrido, color, combustible, precio, transmision);
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
    
    //TOSTRING
    @Override
    public String toString() {
        return "--- INFORMACIÓN DEL VEHÍCULO ---" + "\nTipo de Vehículo: " + tipoVehiculo + "\nPlaca: " + placa + "\nMarca: " + marca + "\nTipo de motor: " + motor + "\nAño: " + anio + "\nRecorrido: " + recorrido + " Km \nColor: " + color + "\nTipo combustible: " + combustible + "\nPrecio: " + precio + "\nTransmision: " + transmision + "\nNúmero de ventanas: " + vidrios;
    }
}