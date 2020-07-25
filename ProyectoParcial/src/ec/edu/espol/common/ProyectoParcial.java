
package ec.edu.espol.common;

import ec.edu.espol.util.Vehiculo;
import ec.edu.espol.util.Vendedor;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author Grupo
 */
public class ProyectoParcial {        
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("*************** BIENVENIDO ****************");
        System.out.println("Coloca un número de acuerdo a la opcion que mas se ajuste: ");
        System.out.println("1. Vendedor");
        System.out.println("2. Comprador");
        System.out.println("3. Salir");
        System.out.print("Ingrese el número: ");
        int opcion=sc.nextInt();
        System.out.println(opcion);
        while(opcion>3 || opcion<=0){                                              //Validación de que la opción ingresada esté en un rango del 1 al 3
            System.out.println("La opción ingresada no esta disponible, escoge entre las opciones del menú");
            System.out.print("Ingrese un numero: ");
            opcion=sc.nextInt();
        }
        while(opcion!=3){
            switch (opcion){
            case 1:                                                                 //Ingreso en la opción vendedor
                System.out.println("1. Registrar nuevo vendedor ");
                System.out.println("2. Ingresar un nuevo vehiculo: ");
                System.out.println("3. Aceptar oferta ");
                System.out.println("4. Regresar ");       
                System.out.println("Ingrese el número: ");
                int opcion2= sc.nextInt();
                switch(opcion2){
                    case 1:                                                     //1. Ingreso de nuevo usuario
                        System.out.println("*** Por favor, ingrese los datos de acontinuación para su registro ***");
                        //Llamar metodo nuevoVendedor ---> Método estático
                        System.out.println("Ingrese su cedula: ");
                        String ced=sc.nextLine();
                        System.out.print("Nombres: ");
                        String nombres=sc.nextLine();
                        System.out.print("Apellido: ");
                        String apellidos= sc.nextLine();
                        System.out.print("Corre Electronico: ");
                        String correo= sc.nextLine();
                        while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){        //Validación de ingreso correcto del campo correo
                            System.out.print("Correo Invalido, Ingrese otro: ");
                            correo=sc.nextLine();
                        }
                        System.out.print("Organización: ");
                        String org= sc.nextLine();
                        System.out.print("Usuario: ");
                        String user= sc.nextLine();
                        System.out.println("Clave: ");
                        String clave = sc.nextLine();
                        Vendedor us1= new Vendedor(nombres, apellidos, ced, correo, org, user, clave);
                        us1.registrarVendedor(clave);//AGREGAR EL ARCHIVO 
                        System.out.println(us1);
                        break;
                    case 2:                                                     //2. Ingreso de un nuevo vehículo
                        System.out.print("Ingrese su usuario: ");
                        String us=sc.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        String cont=sc.nextLine();
                        //Validar que las credenciales sean correctas para continuar 
                        //Dedería ir dentro de un método llamado ingresarVehiculo ---> método estático
                        /*if(){
                            
                        }*/
                        System.out.println("Ingrese el tipo de vehiculo que desea registrar: ");
                        String tipoVehiculo=sc.nextLine();
                        if (tipoVehiculo.equals("Camion")||tipoVehiculo.equals("Auto")||tipoVehiculo.equals("Camioneta")){
                        System.out.println("Ingrese la placa del vehiculo: ");
                        String placa=sc.nextLine();
                        System.out.println("Ingrese la marca del vehículo: ");
                        String marca= sc.nextLine();
                        System.out.println("Ingrese el modelo del vehiculo: ");
                        String modelo= sc.nextLine();
                        System.out.println("Ingrese el tipo de motor: ");
                        String motor=sc.nextLine();
                        System.out.println("Ingrese el año: ");
                        int anio=sc.nextInt();
                        System.out.println("Ingrese el recorrido: ");
                        double recorrido=sc.nextDouble();
                        System.out.println("Ingrese el color del vehiculo: ");
                        String color=sc.nextLine();
                        System.out.println("Ingrese el tipo de combustible que usa el vehículo: ");
                        String combustible=sc.nextLine();
                        System.out.println("Ingrese la transmisión: ");
                        String transmision=sc.nextLine();
                        System.out.println("Ingrese el precio del Vehículo: ");
                        double precio=sc.nextDouble();
                        //Vehiculo vn=new Vehiculo(placa,marca, modelo, motor, anio, double recorrido, String color, String combustible, double precio, String transmision);
                        }
                        
                        
                        break;
                    
                    case 3: 
                        System.out.print("Ingrese su usuario: ");
                        String us2=sc.nextLine();
                        System.out.println("Ingrese su contrseña: ");
                        String cont2=sc.nextLine();
                        //Validar que los campos son correctos con método verificarIngreso de la clase Usuario --> método estático¿?
                        break;
                    case 4: 
                        break;
                    }
                    default:
                        break;
                        
            case 2:                                                             //Ingreso en la opción comprador
                System.out.println("1. Ingresar nuevo comprador: ");
                System.out.println("2. Ofertar por un vehiculo ");
                    int op2=sc.nextInt();

                    switch(op2){
                        case 1:
                        System.out.println("Ingrese los siguientes datos");    
                        System.out.println("Nombres");
                        String nomb=sc.nextLine();
                        System.out.println("Apellidos: ");
                        String apell=sc.nextLine();
                        System.out.println("Correo Elecectronico: ");
                        String correo= sc.nextLine();
                        while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){
                            System.out.print("Correo Invalido, Ingrese otro: ");
                            correo=sc.nextLine();
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
