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
    public Motocicleta(String tipoVehiculo, String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, String transmision, double precio, String tipo) {
        super(tipoVehiculo, placa, marca, modelo, motor, año, recorrido, color, combustible, transmision, precio);
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
    
    @Override
    public void imprimirVehiculo() {
        System.out.println("**** DATOS DEL VEHICULO ****");
        System.out.println("Tipo de Vehículo: " + this.tipoVehiculo + "\nPlaca: " + this.placa + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nMotor: " + this.motor + "\nAño: " + this.anio + "\nRecorrido: " + this.recorrido + "\nColor: " + this.color + "\nTipo de Combustible: " + this.combustible + "\nTrnasmisión: " + this.transmision + "\nTipo de Motocicleta: " + this.tipo +"\nPrecio: " + this.precio);
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return  tipoVehiculo + "," + placa + "," + marca + "," + modelo + "," + motor + "," + anio + "," + recorrido + "," + color + "," + combustible + "," + transmision + "," + tipo + "," + precio ;
    }
}
