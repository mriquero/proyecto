/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.util.Objects;

/**
 *
 * @author macbookpro
 */
public class Vehiculo {
    //ATRIBUTOS
    protected String placa;
    protected String marca;
    protected String motor;  // Tipo de motor
    protected int anio;
    protected double recorrido;
    protected String color;
    protected String combustible;  //Tipo de combustible
    protected double precio;
    protected String transmision;
    
    //CONSTRUCTORES
    public Vehiculo() {
    }
    public Vehiculo(String placa, String marca, String motor, int anio, double recorrido, String color, String combustible, double precio, String transmision) {
        this.placa = placa;
        this.marca = marca;
        this.motor = motor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.transmision = transmision;
    }
    
    //GETTERS
    public String getPlaca() {
        return placa;
    }
    public String getMarca() {
        return marca;
    }
    public String getMotor() {
        return motor;
    }
    public int getAño() {
        return anio;
    }
    public double getRecorrido() {
        return recorrido;
    }
    public String getColor() {
        return color;
    }
    public String getCombustible() {
        return combustible;
    }
    public double getPrecio() {
        return precio;
    }
    public String getTransmision() {
        return transmision;
    }
    
    //SETTERS
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public void setAño(int anio) {
        if (anio>=1800)
            this.anio = anio;
    }
    public void setRecorrido(double recorrido) {
        if (recorrido>=0)
            this.recorrido = recorrido;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
    public void setPrecio(double precio) {
        if (precio>=0)
            this.precio = precio;
    }
    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
    //EQUALS
    @Override
    public boolean equals(Object o) {
        if (o==null)        
            return false;
        if (this==o)        
            return true;
        if (this.getClass()!= o.getClass())    
            return false;
        
        Vehiculo other = (Vehiculo)o;
        return Objects.equals(this, other);
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return "--- INFORMACIÓN DEL VEHÍCULO ---" + "\nPlaca: " + placa + "\nMarca: " + marca + "\nTipo de motor: " + motor + "\nAño: " + anio + "\nRecorrido: " + recorrido + " Km \nColor: " + color + "\nTipo combustible: " + combustible + "\nPrecio: " + precio + "\nTransmision: " + transmision;
    }
    
}
