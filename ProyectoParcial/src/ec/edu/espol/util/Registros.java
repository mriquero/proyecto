/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static ArrayList<Registros> leerRegistro(String archivo){
        ArrayList<Registros> reg=new ArrayList<>();
        try(Scanner sc= new Scanner(new File(archivo))){
            while(sc.hasNextLine()){
                String[] atrib=sc.nextLine().split(",");
                Registros r= new Registros(atrib[0],Integer.parseInt(atrib[1]),Integer.parseInt(atrib[2]),Integer.parseInt(atrib[3]),Integer.parseInt(atrib[4]),Double.parseDouble(atrib[5]),Double.parseDouble(atrib[6]));
                reg.add(r);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }return reg;
    }
    public void registrarReg(String archivo)
    {
        try(FileWriter fw = new FileWriter(archivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter addTxt = new PrintWriter(bw))
        {
            addTxt.println(this);
        }
        catch (Exception v)
        {
            System.out.println(v.getMessage());
        }
    }    
    
    public static void vincular(ArrayList<Vehiculo> vehiculos,ArrayList<Registros> registro){
        for(Registros r: registro){
            String tipo=r.getTipoVehiculo();
            int recorrIn=r.getRecIn();
            int recorrFin=r.getRecFin();                        
        }
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setRecIn(int recIn) {
        this.recIn = recIn;
    }

    public void setRecFin(int recFin) {
        this.recFin = recFin;
    }

    public void setAnioIn(int anioIn) {
        this.anioIn = anioIn;
    }

    public void setAnioFin(int anioFin) {
        this.anioFin = anioFin;
    }

    public void setPrecioIn(double precioIn) {
        this.precioIn = precioIn;
    }

    public void setPrecioFin(double precioFin) {
        this.precioFin = precioFin;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public int getRecIn() {
        return recIn;
    }

    public int getRecFin() {
        return recFin;
    }

    public int getAnioIn() {
        return anioIn;
    }

    public int getAnioFin() {
        return anioFin;
    }

    public double getPrecioIn() {
        return precioIn;
    }

    public double getPrecioFin() {
        return precioFin;
    }
    
    @Override
    public String toString() {
        return  tipoVehiculo + "," + recIn + "," + recFin + "," + anioIn + "," + anioFin + "," + precioIn + "," + precioFin ;
    }
    
    
    
}
