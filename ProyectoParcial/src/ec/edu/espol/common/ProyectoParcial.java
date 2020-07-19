/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author macbookpro
 */
public class ProyectoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("***************BIENVENIDO****************");
        System.out.println("Coloca un número de acuerdo a la opcion que mas se ajuste: ");
        System.out.println("1. Vendedor");
        System.out.println("2. Comprador");
        System.out.println("3. Salir");
        System.out.println("Ingrese el número: ");
        int opcion=sc.nextInt();
        System.out.println(opcion);
        
        switch (opcion){
            case 1: 
                
                System.out.println("1. Registrar nuevo vendedor ");
                System.out.println("2. Ingresar un nuevo vehiculo: ");
                System.out.println("3. Aceptar oferta ");
                System.out.println("4. Regresar ");
                System.out.println("Ingrese el número: ");
                int opcion2= sc.nextInt();
                switch(opcion2){
                    case 1:
                        System.out.println("Registre los datos a continuación: ");
                        System.out.println("Nombre: ");
                        String name=sc.next();
                        System.out.println("El nombre es "+ name);
                        System.out.print("Apellido: ");
                        String lName= sc.nextLine();
                        System.out.println(lName);
                        System.out.print("Corre Electronico: ");
                        String correo= sc.nextLine();
                        while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){
                            System.out.print("Correo Invalido, Ingresa otro: ");
                            String correoN=sc.nextLine();
                            correo=correoN;
                        }
                        System.out.println("Organización: ");
                        String org= sc.nextLine();

                }
                break;
            case 2: System.out.print("Ingrese su usuario: ");
                    String us=sc.nextLine();
                    System.out.println("Ingrese su contrseña: ");
                    
                break;
            case 3: System.out.print("Ingrese su usuario: ");
                    String us2=sc.nextLine();
                    System.out.println("Ingrese su contrseña: ");
            case 4: 
                break;
            
                
        }
    
}}
