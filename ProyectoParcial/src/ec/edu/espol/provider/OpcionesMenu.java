/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.provider;

import java.util.ArrayList;

/**
 *
 * @author Mile
 */
public class OpcionesMenu {
    public static void menuPrincipal(){
        System.out.println("                      *************** BIENVENIDO ****************                     "); 
        System.out.println("Coloca un número de acuerdo a la opcion que mas se ajuste: ");
        System.out.println("1. Vendedor");
        System.out.println("2. Comprador");
        System.out.println("3. Salir");
        System.out.print("Ingrese un número: ");
    }
    public static void menuVendedor(){
        System.out.println("1. Registrar un nuevo vendedor");
        System.out.println("2. Ingresar un nuevo vehículo");
        System.out.println("3. Aceptar Oferta");
        System.out.println("4. Regresar");
        System.out.print("--> ");
    }
    public static void menuComprador() {
        System.out.println("1. Registrar un nuevo comprador");
        System.out.println("2. Ofertar por un vehículo");
        System.out.println("3. Regresar");
        System.out.print("--> ");
    
    }
    public static void menuOferta(int i , int f){
        if (i==0){
        System.out.println("1. Siguiente Oferta");
        System.out.println("2. Aceptar oferta");
        System.out.print("--> ");
        }
        else if(i==(f-1)){
            System.out.println("1. Anterior Oferta");
            System.out.println("2. Aceptar oferta");
            System.out.print("--> ");
        }
        else {        
            System.out.println("1. Anterior oferta");
            System.out.println("2. Siguiente Oferta");
            System.out.println("3. Aceptar Oferta");
            System.out.print("--> ");
        }

    }
    
}
