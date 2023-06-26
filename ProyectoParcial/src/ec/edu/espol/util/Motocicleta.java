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
   public Motocicleta(String tipoVehiculo, String placa, String marca, String modelo, String motor, int anio, double recorrido, String color, String combustible, String transmision, double precio, String tipo) {
    super(tipoVehiculo, placa, marca, modelo, motor, anio, recorrido, color, combustible, transmision, precio);
    this.tipo = tipo;
    }


    Motocicleta(String tipo, String placa, String marca, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    super.imprimirVehiculo(); // Llamar al método de la clase base para mostrar los detalles generales del vehículo
    System.out.println("Tipo de Motocicleta: " + this.tipo); // Mostrar solo el detalle específico de la motocicleta
    }


    
    //TOSTRING
    @Override
    public String toString() {
        return  tipoVehiculo + "," + placa + "," + marca + "," + modelo + "," + motor + "," + anio + "," + recorrido + "," + color + "," + combustible + "," + transmision + "," + tipo + "," + precio ;
    }
}
