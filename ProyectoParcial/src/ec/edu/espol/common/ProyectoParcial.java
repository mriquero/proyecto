
package ec.edu.espol.common;

import ec.edu.espol.util.Auto;
import ec.edu.espol.util.Comprador;
import ec.edu.espol.util.Registros;
import ec.edu.espol.util.Vehiculo;
import ec.edu.espol.util.Vendedor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author Grupo
 */
public class ProyectoParcial {        
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc= new Scanner(System.in);
        //OPCION DE MOSTRAR
        
        /*String cadena=JOptionPane.showInputDialog("                 *************** BIENVENIDO ****************"
                + "\nColoca un número de acuerdo a la opcion que mas se ajuste: "
                + "\n1. Vendedor"
                + "\n2. Comprador"
                + "\n3. Salir");
        int op=Integer.parseInt(cadena);//MUESTRA.....................................................*/
        System.out.println("                      *************** BIENVENIDO ****************                     "); 
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
                        System.out.println("*** Por favor, ingrese los datos de acontinuación para su registro ***            ");
                        //Llamar metodo nuevoVendedor ---> Método estático
                        System.out.println("Ingrese su cedula: ");
                        String ced=sc.next();
                        System.out.print("Nombres: ");
                        String nombres=sc.next();
                        System.out.print("Apellido: ");
                        String apellidos= sc.next();
                        System.out.print("Corre Electronico: ");
                        String correo= sc.next();
                        while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){        //Validación de ingreso correcto del campo correo
                            System.out.print("Correo Invalido, Ingrese otro: ");
                            correo=sc.nextLine();
                        }
                        System.out.print("Organización: ");
                        String org= sc.next();
                        System.out.print("Usuario: ");
                        String user= sc.next();
                        System.out.println("Clave: ");
                        String clave = sc.next();
                        Vendedor us1= new Vendedor(nombres, apellidos, ced, correo, org, user, clave);
                        us1.registrarVendedor("Vendedores.txt");//AGREGAR EL ARCHIVO 
                        System.out.println(us1);
                        break;
                    case 2:                                                     //2. Ingreso de un nuevo vehículo
                        System.out.print("Ingrese su usuario: ");
                        String us=sc.next();
                        System.out.println("Ingrese su contraseña: ");
                        String cont=sc.next();
                        //Validar que las credenciales sean correctas para continuar 
                        //Dedería ir dentro de un método llamado ingresarVehiculo ---> método estático                        
                        System.out.println("Ingrese el tipo de vehiculo que desea registrar: ");
                        String tipoVehiculo=sc.next();                        
                        System.out.println("Ingrese la placa del vehiculo: ");
                        String placa=sc.next();
                        System.out.println("Ingrese la marca del vehículo: ");
                        String marca= sc.next();
                        System.out.println("Ingrese el modelo del vehiculo: ");
                        String modelo= sc.next();
                        System.out.println("Ingrese el tipo de motor: ");
                        String motor=sc.next();
                        System.out.println("Ingrese el año: ");
                        int anio=sc.nextInt();
                        System.out.println("Ingrese el recorrido: ");
                        double recorrido=sc.nextDouble();
                        System.out.println("Ingrese el color del vehiculo: ");
                        String color=sc.next();
                        System.out.println("Ingrese el tipo de combustible que usa el vehículo: ");
                        String combustible=sc.next();
                        System.out.println("Ingrese la transmisión: ");
                        String transmision=sc.next();
                        System.out.println("Ingrese el precio del Vehículo: ");
                        double precio=sc.nextDouble();
                        int vidrioN = 0;
                        if (tipoVehiculo.equals("Camion")||tipoVehiculo.equals("Auto")||tipoVehiculo.equals("Camioneta")){
                            System.out.println("Ingrese el numero de vidrios");
                            int vidrios=sc.nextInt();
                            vidrioN=vidrioN;
                        }
                        
                        Auto vn=new Auto(tipoVehiculo,placa,marca, modelo, motor, anio, recorrido, color, combustible, transmision, precio,vidrioN);
                        vn.registrarVehiculo("Vehiculos.txt");
                        ArrayList<Auto> listAut=Auto.leerRegistroAutos("Vehiculos.txt");
                        ArrayList<Registros> listReg= Registros.leerRegistro("Registros.txt");
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
                System.out.print("Ingrese la opcion que desee: ");
                    int op2=sc.nextInt();

                    switch(op2){                                               
                        case 1:
                        
                        System.out.println("Ingrese los siguientes datos");    
                        System.out.println("Nombres: ");
                        String nomb=sc.next();
                        System.out.println("Apellidos: ");
                        String apell=sc.next();
                        System.out.println("Ingrese su cedula: ");
                        String ced=sc.next();
                        System.out.println("Correo Elecectronico: ");
                        String correo= sc.next();
                        while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){
                            System.out.print("Correo Invalido, Ingrese otro: ");                            
                            correo=sc.nextLine();
                        }
                        System.out.println("Organización: ");
                        String org= sc.next();
                        System.out.println("Usuario: ");
                        String user=sc.next();
                        System.out.println("Clave: ");
                        String cont= sc.next();
                        Comprador cn= new Comprador(nomb,apell,correo,ced,org,user,cont);                        
                            cn.registrarComprador("Compradores.txt");                                                                        
                        System.out.println("El registro se ha completado exitosamente");
                        break;                
                        case 2:
                           System.out.println("Ingrese el tipo de vehiculo");
                            String tipo=sc.next();
                            System.out.println("Ingrese el intervalo del recorrido ");
                            System.out.println("Inicio: ");
                            String inicio=sc.next();
                            System.out.println("Final");
                            String fin = sc.next();
                            System.out.println("Ingrese el intervalo del año: ");
                            System.out.println("Inicio: ");
                            String iniAnio=sc.next();
                            System.out.println("Final: ");
                            String finAnio=sc.next();
                            System.out.println("Ingrese el intervalo del precio: ");
                            System.out.println("Inicio: ");                            
                            double iniPrec=sc.nextDouble();
                            System.out.println("Final: ");
                            double finPrec=sc.nextDouble();
                           //Vehiculo vn=new Auto(tipo,inicio,iniAnio,iniPrec);
                           ArrayList atrib= new ArrayList();
                           atrib.add(tipo);
                           atrib.add(inicio);
                           atrib.add(fin);
                           atrib.add(iniAnio);
                           atrib.add(finAnio);
                           atrib.add(iniPrec);
                           System.out.println(Vehiculo.Buscar("Vehiculos.txt", atrib));
                            break;
                        default:
                        break;
                    }           
                }
        }
 try{
    FileReader doc=new FileReader("registro.txt");
    BufferedReader br= new BufferedReader(doc);
    br.readLine();
}  catch(Exception v){
     System.out.println(v.getMessage());
    
}      

        }
        
    
}
