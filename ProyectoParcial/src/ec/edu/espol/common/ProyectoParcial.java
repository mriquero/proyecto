/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import ec.edu.espol.util.Vehiculo;
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
        while(opcion>3 || opcion<=0){
            System.out.println("La opción ingresada no esta disponible, escoge entre las opciones del menú");
            System.out.println("Ingrese un numero");
            int op2=sc.nextInt();
            opcion=op2;
        }
        while(opcion!=3){
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
                        //System.out.println("Registre los datos a continuación: ");
                        System.out.println("Nombre: \n");
                        String nom=sc.nextLine();
                        System.out.println("El nombre es "+ nom);
                        System.out.print("Apellido: ");
                        String lName= sc.nextLine();
                        System.out.println("El apellido es "+lName);
                        System.out.println(lName);
                        System.out.print("Corre Electronico: ");
                        String correo= sc.nextLine();
                        while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){
                            System.out.print("Correo Invalido, Ingresa otro: ");
                            String correoN=sc.nextLine();
                            correo=correoN;
                        }
                        //System.out.println("Organización: ");
                        //String org= sc.nextLine();
                    break;
            case 2: System.out.print("Ingrese su usuario: ");
                    String us=sc.nextLine();
                    System.out.println("El usario es: "+ us);
                    System.out.println("Ingrese su contrseña: ");
                    String cont=sc.nextLine();
                    System.out.println("Su contraseña es: "+ cont);
                    System.out.println("Ingrese su placa: ");
                    String placa=sc.nextLine();
                    System.out.println("Ingrese su vehiculo: ");
                    String marca=sc.nextLine();
                    System.out.println("Ingrese el modelo: ");
                    String modelo= sc.nextLine();
                    System.out.println("Ingrese el tipo de motor");
                    String motor=sc.nextLine();
                    System.out.println("Ingrese el año");
                    int anio=sc.nextInt();
                //Vehiculo vn=new Vehiculo(placa,marca, modelo, motor, anio, double recorrido, String color, String combustible, double precio, String transmision);
                break;
            case 3: System.out.print("Ingrese su usuario: ");
                    String us2=sc.nextLine();
                    System.out.println("El usario es: "+ us2);
                    System.out.println("Ingrese su contrseña: ");
                    String cont2=sc.nextLine();
                    System.out.println("Su contraseña es: "+ cont2);
                    System.out.println("Ingrese su contrseña: ");
            case 4: 
                break;
                }default:
                    break;
        case 2: 
            System.out.println("1. Ingresar nuevo comprador: ");
            System.out.println("2. Ofertar por un vehiculo ");
                int op2=sc.nextInt();
                
                switch(op2){
                    case 1:
                    System.out.println("Ingrese los datos");    
                    System.out.println("Nombres");
                    String nomb=sc.nextLine();
                    System.out.println("Apellidos: ");
                    String apell=sc.nextLine();
                    System.out.println("Correo Elecectronico: ");
                    String correo= sc.nextLine();
                        while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){
                            System.out.print("Correo Invalido, Ingresa otro: ");
                            String correoN=sc.nextLine();
                            correo=correoN;
                        }
                
                        System.out.println("Organización: ");
                        String org= sc.nextLine();
                    System.out.println("Usuario: ");
                    String user=sc.nextLine();
                    System.out.println("Clave: ");
                    String cont= sc.nextLine();
                    break;
                    case 2:
                        System.out.println("no");
                        break;
                    default:
                    break;
               
                }
            
        
               
        }
        }
        
    
}

}
