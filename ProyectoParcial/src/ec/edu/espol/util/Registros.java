/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

/**
 *
 * @author Administración
 */
public class Registros {
    private String tipoVehiculo;
    private int recIn;
    private int recFin;
    private int anioIn;
    private int anioFin;
    private double precioIn;
    private double precioFin;

    public Registros(String tipoVehiculo, int recIn, int recFin, int anioIn, int anioFin, double precioIn, double precioFin) {
        this.tipoVehiculo = tipoVehiculo;
        this.recIn = recIn;
        this.recFin = recFin;
        this.anioIn = anioIn;
        this.anioFin = anioFin;
        this.precioIn = precioIn;
        this.precioFin = precioFin;
    }
    
    
    
}
