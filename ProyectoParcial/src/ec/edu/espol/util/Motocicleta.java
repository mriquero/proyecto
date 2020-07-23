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
public class Motocicleta extends Vehiculo {
    //ATRIBUTOS
    private String tipo; //Tipo de Motocicleta

    //CONSTRUCTORES
    public Motocicleta() {
    }
    public Motocicleta(String placa, String marca, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision, String tipo) {
        super(placa, marca, motor, año, recorrido, color, combustible, precio, transmision);
        this.tipo = tipo;
    }
    
    //GETTERS
    public String getTipo() {
        return tipo;
    }
    
    //SETTERS
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return "--- INFORMACIÓN DEL VEHÍCULO ---" + "\nTipo de Vehículo: Motocicleta" + "\nPlaca: " + placa + "\nMarca: " + marca + "\nTipo de motor: " + motor + "\nAño: " + anio + "\nRecorrido: " + recorrido + " Km \nColor: " + color + "\nTipo combustible: " + combustible + "\nPrecio: " + precio + "\nTransmision: " + transmision + "\nTipo de motocicleta: " + tipo;
    }
}
