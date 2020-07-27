/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.common;

import ec.edu.espol.provider.OpcionesMenu;
import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espol.util.Auto;
import ec.edu.espol.util.Camion;
import ec.edu.espol.util.Camioneta;
import ec.edu.espol.util.Comprador;
import ec.edu.espol.util.Encriptar;
import static ec.edu.espol.util.Encriptar.encriptaHex;
import static ec.edu.espol.util.Encriptar.to256;
import ec.edu.espol.util.Motocicleta;
import ec.edu.espol.util.Oferta;
import ec.edu.espol.util.Usuario;
import ec.edu.espol.util.Vehiculo;
import ec.edu.espol.util.Vendedor;
import ec.edu.espol.util.Venta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mile
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc= new Scanner(System.in);
        sc.useDelimiter("\n");
        ArrayList<Integer> opciones = new ArrayList<>();
        opciones.add(1);
        opciones.add(2);
        opciones.add (3);
        int opcion;
        do{        
            OpcionesMenu.menuPrincipal();
            opcion = sc.nextInt();
            while (!opciones.contains(opcion)){
                System.out.println("**OPCIÓN NO VÁLIDA**");
                System.out.print("Ingrese un número: ");
                opcion = sc.nextInt();
            }
            switch (opcion){
                case 1:
                    ArrayList<Integer> subopciones = new ArrayList<>();
                    subopciones.add(1);
                    subopciones.add(2);
                    subopciones.add(3);
                    subopciones.add(4);
                    int subopcion;
                    do {
                        OpcionesMenu.menuVendedor();
                        subopcion = sc.nextInt();
                        while (!subopciones.contains(subopcion)){
                            System.out.println("**OPCIÓN NO VÁLIDA**");
                            System.out.print("--> ");
                            subopcion = sc.nextInt();
                        }
                        switch(subopcion){
                            case 1:  //Esta opción ingresa un nuevo vendedor                
                                System.out.println("*** Por favor, ingrese los datos de acontinuación para su registro ***");
                                System.out.print("Cédula: ");
                                String ci=sc.next();
                                System.out.print("Nombres: ");
                                String nombres=sc.next();
                                System.out.print("Apellidos: ");
                                String apellidos= sc.next();
                                System.out.print("Correo Electrónico: ");
                                String correo=sc.next();
                                while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){        //Validación de ingreso correcto del campo correo
                                    System.out.print("Correo Invalido, Ingrese otro: ");
                                    correo=sc.next();
                                }
                                System.out.print("Organización: ");
                                String org= sc.next();
                                System.out.print("Usuario: ");
                                String user= sc.next();
                                System.out.print("Clave: ");
                                String clave = sc.next();
                                String claveEncrip= encriptaHex(to256(clave));
                                //System.out.println(claveEncrip);
                              
                                Vendedor us1= new Vendedor(nombres, apellidos, ci, correo, org, user, claveEncrip);
                                
                                us1.registrarVendedor("Vendedores.txt");
                                System.out.println(" ");
                                us1.imprimirUsuario();
                                break;
                                
                            case 2:   //Esta opción ingresa un nuevo vehículo
                                boolean validar;
                                String us;
                                String cont;
                                do{
                                    System.out.print("Ingrese su usuario: ");
                                    us=sc.next();
                                    System.out.print("Ingrese su contraseña: ");
                                    cont=sc.next();
                                    String contEncrip= encriptaHex(to256(cont));
                                    //System.out.println(contEncrip);
                                    validar= Usuario.validarIngreso("Vendedores.txt",us,contEncrip);
                                    //System.out.println(validar);
                                }while (validar==false);
                                    System.out.println("Ingrese el tipo de vehiculo que desea registrar: ");
                                    String tipoVehiculo=sc.next();
                                    System.out.print("Ingrese la placa del vehiculo: ");
                                    String placa=sc.next();
                                    System.out.print("Ingrese la marca del vehículo: ");
                                    String marca= sc.next();
                                    System.out.println("Ingrese el modelo del vehiculo: ");
                                    String modelo= sc.next();
                                    System.out.println("Ingrese el tipo de motor: ");
                                    String motor=sc.next();
                                    System.out.print("Ingrese el año: ");
                                    int anio=sc.nextInt();
                                    System.out.print("Ingrese el recorrido: ");
                                    double recorrido=sc.nextDouble();
                                    System.out.print("Ingrese el color del vehiculo: ");
                                    String color=sc.next();
                                    System.out.print("Ingrese el tipo de combustible que usa el vehículo: ");
                                    String combustible=sc.next();
                                    System.out.print("Ingrese la transmisión: ");
                                    String transmision=sc.next();
                                    System.out.print("Ingrese el precio del Vehículo: ");
                                    double precio=sc.nextDouble();
                                    switch (tipoVehiculo){
                                        case "auto":
                                            System.out.print("Ingrese el número de vidrios: ");
                                            int vidrios=sc.nextInt();
                                            Auto vn= new Auto(tipoVehiculo,placa,marca,modelo,motor,anio,recorrido,color,combustible,transmision,precio,vidrios);
                                            vn.registrarVehiculo("Vehiculos.txt");
                                            break;
                                        case "camion":
                                            System.out.print("Ingrese el número de vidrios: ");
                                            int vidrios1=sc.nextInt();
                                            Camion vn1= new Camion(tipoVehiculo,placa,marca,modelo,motor,anio,recorrido,color,combustible,transmision,precio,vidrios1);
                                            vn1.registrarVehiculo("Vehiculos.txt");
                                            break;
                                        case "camioneta":
                                            System.out.print("Ingrese el número de vidrios: ");
                                            int vidrios2=sc.nextInt();
                                            Camioneta vn2= new Camioneta(tipoVehiculo,placa,marca,modelo,motor,anio,recorrido,color,combustible,transmision,precio,vidrios2);
                                            vn2.registrarVehiculo("Vehiculos.txt");
                                            break;
                                        case "motocicleta":
                                            System.out.print("Ingrese el tipo de motocicleta: ");
                                            String tipo=sc.next();
                                            Motocicleta vn3= new Motocicleta(tipoVehiculo,placa,marca,modelo,motor,anio,recorrido,color,combustible,transmision,precio,tipo);
                                            vn3.registrarVehiculo("Vehiculos.txt");
                                            break;
                                        default:
                                            break;
                                    }
                                break;
                            case 3:
                                boolean validar1;  
                                String us0;
                                String cont0;
                                do{
                                System.out.print("Ingrese su usuario: ");
                                us0=sc.next();
                                System.out.print("Ingrese su contraseña: ");
                                cont0=sc.next();
                                String contEncrip0= encriptaHex(to256(cont0));
                                //System.out.println(contEncrip0);
                                validar= Usuario.validarIngreso("Vendedores.txt",us0,contEncrip0); //Aqui se valida el usuario y la contraseña
                                }while (validar==false);
                                //----------------------------------------------------------------
                                ArrayList<String> info = new ArrayList<> ();
                                try{
                                    BufferedReader buff = new BufferedReader(new FileReader("Vendedores.txt"));
                                    String buffRead;
                                    while ((buffRead=buff.readLine())!=null){
                                        String [] linea= buffRead.split(",");
                                        if (linea[5].equals(us0)){
                                            info.add(linea[0]);
                                            info.add(linea[1]);
                                            info.add(linea[2]);
                                            info.add(linea[3]);
                                            info.add(linea[4]);
                                            info.add(linea[5]);
                                            info.add(linea[6]);
                                        }
                                    }
                                }catch(Exception e){
                                    System.out.println("File not found");
                                }
                                Vendedor vendedor = new Vendedor(info.get(0),info.get(1),info.get(2),info.get(3),info.get(4),info.get(5),info.get(6));
                                //vendedor.imprimirUsuario();
                                //----------------------------------------------------------------
                                boolean existe=false;
                                ArrayList<String> infovehiculo = new ArrayList<>();
                                String placaOfertas;
                                do{
                                    System.out.print("Ingrese la placa: ");
                                    placaOfertas= sc.next();
                                    try (Scanner sc1 = new Scanner (new File ("Vehiculos.txt"))){
                                        while (sc1.hasNextLine()){
                                            String[] inffo = sc1.nextLine().split(",");
                                            if (placaOfertas.equals(inffo[1])){
                                                existe=true;
                                                infovehiculo.add(inffo[0]); infovehiculo.add(inffo[1]);infovehiculo.add(inffo[2]);infovehiculo.add(inffo[3]); infovehiculo.add(inffo[4]);infovehiculo.add(inffo[5]);infovehiculo.add(inffo[6]);infovehiculo.add(inffo[7]);infovehiculo.add(inffo[8]);infovehiculo.add(inffo[9]);infovehiculo.add(inffo[10]);infovehiculo.add(inffo[11]);
                                            }
                                        }
                                    }  catch(Exception e){
                                         System.out.println(e.getMessage());
                                    }
                                }while(existe==false);
                                ArrayList<String> presentar = new ArrayList<>();
                                try{
                                    BufferedReader buff = new BufferedReader(new FileReader("Ofertas.txt"));
                                    String buffRead;
                                    while ((buffRead=buff.readLine())!=null){
                                        String [] linea= buffRead.split(",");
                                        if (linea[0].equals(placaOfertas)){
                                            presentar.add(buffRead);
                                        }
                                    }
                                }catch(Exception e){
                                    System.out.println("File not found");
                                }
                                int i=0;
                                int f=presentar.size();
                                int indice=0;
                                while (i<f){
                                    System.out.println("Oferta "+(i+1));
                                    String[] infoOf = presentar.get(i).split(",");
                                    Oferta oferta = new Oferta(infoOf[0],infoOf[1],Double.parseDouble(infoOf[2]));
                                    oferta.imprimirOferta();
                                    OpcionesMenu.menuOferta(i, f);
                                    int op = sc.nextInt();
                                    if (i==0){
                                        switch(op){
                                            case 1:
                                                i++;
                                                break;
                                            case 2:
                                                indice=i;
                                                i=f;
                                                System.out.println("Se ha aceptado una oferta \nEnviando correo de confirmación...");
                                                Venta venta=vendedor.aceptarOferta(oferta);
                                                /**/
                                                break;
                                            default:
                                                i=f;
                                                break;
                                        }
                                    }

                                    else if(i<(f-1) && i!=0){
                                        switch(op){
                                            case 1:
                                                i--;
                                                break;
                                            case 2:
                                                i++;
                                                break;
                                            case 3:
                                                indice=i;
                                                i=f;
                                                System.out.println("Se ha aceptado una oferta \nEnviando correo de confirmación...");
                                                Venta venta=vendedor.aceptarOferta(oferta);
                                            default:
                                                i=f;
                                                break;
                                        }

                                    }
                                    else if (i==(f-1)){
                                        switch(op){
                                            case 1:
                                                i--;
                                                break;
                                            case 2:
                                                indice=i;
                                                i=f;
                                                System.out.println("Se ha acepta una oferta \nEnviando correo de confirmación...");
                                                Venta venta=vendedor.aceptarOferta(oferta);
                                                System.out.println("");
                                                break;
                                            default:
                                                i=f;
                                                break;
                                        }
                                    }     
                                }
                                break;
                            default:
                                break;}
                    }while(subopcion!=4);
                    break;
        //------------------------------------------------------------------------------------------------------------------------------------        
                case 2:
                    
                    ArrayList<Integer> subopciones1 = new ArrayList<>();
                    subopciones1.add(1);
                    subopciones1.add(2);
                    subopciones1.add(3);
                    int subopcion1;
                    do{
                        OpcionesMenu.menuComprador();
                        subopcion1= sc.nextInt();
                        while (!subopciones1.contains(subopcion1)){
                            System.out.println("**OPCIÓN NO VÁLIDA**");
                            System.out.print("--> ");
                            subopcion1 = sc.nextInt();
                        }
                        switch(subopcion1){
                            case 1:
                                System.out.println("Esta opción registra un nuevo comprador");
                                System.out.println("*** Por favor, ingrese los datos de acontinuación para su registro ***");
                                System.out.print("Cédula: ");
                                String ci=sc.next();
                                System.out.print("Nombres: ");
                                String nombres=sc.next();
                                System.out.print("Apellidos: ");
                                String apellidos= sc.next();
                                System.out.print("Correo Electrónico: ");
                                String correo=sc.next();
                                while(!(correo.contains("@")&&(correo.contains(".com") || correo.contains("ec") || correo.contains("es")))){        //Validación de ingreso correcto del campo correo
                                    System.out.print("Correo Invalido, Ingrese otro: ");
                                    correo=sc.next();
                                }
                                System.out.print("Organización: ");
                                String org= sc.next();
                                System.out.print("Usuario: ");
                                String user= sc.next();
                                System.out.print("Clave: ");
                                String clave = sc.next();
                                String claveEncrip= encriptaHex(to256(clave));
                                //System.out.println(claveEncrip);
                                Comprador us1= new Comprador(nombres, apellidos, ci, correo, org, user, claveEncrip);
                                us1.registrarComprador("Compradores.txt");
                                System.out.println(" ");
                                us1.imprimirUsuario();
                                break;
                            case 2:
                                boolean validar;
                                String us;
                                String cont;
                                do{
                                    System.out.print("Ingrese su usuario: ");
                                    us=sc.next();
                                    System.out.print("Ingrese su contraseña: ");
                                    cont=sc.next();
                                    String contEncrip= encriptaHex(to256(cont));
                                    System.out.println(contEncrip);
                                    validar= Usuario.validarIngreso("Compradores.txt",us,contEncrip); 
                                    System.out.println(validar);
                                }while (validar==false);
                                //----------------------------------------------------------------
                                ArrayList<String> info = new ArrayList<> ();
                                try{
                                    BufferedReader buff = new BufferedReader(new FileReader("Compradores.txt"));
                                    String buffRead;
                                    while ((buffRead=buff.readLine())!=null){
                                        String [] linea= buffRead.split(",");
                                        if (linea[5].equals(us)){
                                            info.add(linea[0]);
                                            info.add(linea[1]);
                                            info.add(linea[2]);
                                            info.add(linea[3]);
                                            info.add(linea[4]);
                                            info.add(linea[5]);
                                            info.add(linea[6]);
                                        }
                                    }
                                }catch(Exception e){
                                    System.out.println("File not found");
                                }
                                Comprador comprador = new Comprador(info.get(0),info.get(1),info.get(2),info.get(3),info.get(4),info.get(5),info.get(6));
                                comprador.imprimirUsuario();
                                //----------------------------------------------------------------
                                System.out.print("Ingrese el tipo de vehiculo");
                                String tipo=sc.next();
                                System.out.println("Ingrese el intervalo del recorrido ");
                                System.out.print("Inicio: ");
                                String inicio=sc.next();
                                System.out.print("Final");
                                String fin = sc.next();
                                System.out.println("Ingrese el intervalo del año");
                                System.out.print("Inicio: ");
                                String iniAnio=sc.next();
                                System.out.print("Final: ");
                                String finAnio=sc.next();
                                System.out.println("Ingrese el intervalo del precio");
                                System.out.print("Inicio: ");                            
                                double iniPrec=sc.nextDouble();
                                System.out.print("Final: ");
                                double finPrec=sc.nextDouble();
                                ArrayList atrib= new ArrayList();
                                atrib.add(tipo);
                                atrib.add(inicio);
                                atrib.add(fin);
                                atrib.add(iniAnio);
                                atrib.add(finAnio);
                                atrib.add(iniPrec);
                                
                                ArrayList<String> vehiculos = Vehiculo.Buscar("Vehiculos.txt", atrib);
                                double precioOfertar=0;
                                int i=0;
                                int indice=0;
                                int f=vehiculos.size();
                                while (i<f){
                                    System.out.println(i);
                                    System.out.println(vehiculos.get(i));
                                    OpcionesMenu.menuOfertar(i, f);
                                    int op = sc.nextInt();
                                    if (i==0){
                                        switch(op){
                                            case 1:
                                                i++;
                                                break;
                                            case 2:
                                                indice=i;
                                                i=f;
                                                System.out.print("Ingrese el precio a ofertar: ");
                                                precioOfertar= sc.nextDouble();
                                                break;
                                            default:
                                                i=f;
                                                break;
                                        }
                                    }
                                    else if(i<(f-1) && i!=0){
                                        switch(op){
                                            case 1:
                                                i--;
                                                break;
                                            case 2:
                                                i++;
                                                break;
                                            case 3:
                                                indice=i;
                                                i=f;
                                                System.out.print("Ingrese el precio a ofertar: ");
                                                precioOfertar= sc.nextDouble();
                                            default:
                                                i=f;
                                                break;
                                        }
                                    }
                                    else if (i==(f-1)){
                                        switch(op){
                                            case 1:
                                                i--;
                                                break;
                                            case 2:
                                                indice=i;
                                                i=f;
                                                System.out.print("Ingrese el precio a ofertar: ");
                                                precioOfertar= sc.nextDouble();
                                                break;
                                            default:
                                                i=f;
                                                break;
                                        }
                                    }
                                }
                                String atri= vehiculos.get(indice);
                                String[] aAtrib = atri.split(",");
                                switch (aAtrib[0]){
                                        case "auto":
                                            Auto vn= new Auto(aAtrib[0],aAtrib[1],aAtrib[2],aAtrib[3],aAtrib[4],Integer.parseInt(aAtrib[5]), Double.parseDouble(aAtrib[6]),aAtrib[7],aAtrib[8],aAtrib[9],Double.parseDouble(aAtrib[11]),Integer.parseInt(aAtrib[10]));
                                            Oferta oferta= new Oferta(comprador, vn ,precioOfertar);
                                            oferta.registrarOferta("Ofertas.txt");
                                            break;
                                        case "camion":
                                            Camion vn1= new Camion(aAtrib[0],aAtrib[1],aAtrib[2],aAtrib[3],aAtrib[4],Integer.parseInt(aAtrib[5]), Double.parseDouble(aAtrib[6]),aAtrib[7],aAtrib[8],aAtrib[9],Double.parseDouble(aAtrib[11]),Integer.parseInt(aAtrib[10]));
                                            Oferta oferta1= new Oferta(comprador, vn1 ,precioOfertar);
                                            oferta1.registrarOferta("Ofertas.txt");
                                            break;
                                        case "camioneta":
                                            Camioneta vn2= new Camioneta(aAtrib[0],aAtrib[1],aAtrib[2],aAtrib[3],aAtrib[4],Integer.parseInt(aAtrib[5]), Double.parseDouble(aAtrib[6]),aAtrib[7],aAtrib[8],aAtrib[9],Double.parseDouble(aAtrib[11]),Integer.parseInt(aAtrib[10]));
                                            Oferta oferta2= new Oferta(comprador, vn2 ,precioOfertar);
                                            oferta2.registrarOferta("Ofertas.txt");
                                            break;
                                        case "motocicleta":
                                            Motocicleta vn3= new Motocicleta(aAtrib[0],aAtrib[1],aAtrib[2],aAtrib[3],aAtrib[4],Integer.parseInt(aAtrib[5]), Double.parseDouble(aAtrib[6]),aAtrib[7],aAtrib[8],aAtrib[9],Double.parseDouble(aAtrib[11]),aAtrib[10]);
                                            Oferta oferta3= new Oferta(comprador, vn3 ,precioOfertar);
                                            oferta3.registrarOferta("Ofertas.txt");break;
                                        default:
                                            break;
                                    }
                                break;
                            default:
                                break;                       
                        }
                    }while(subopcion1!=3);
                    break;
                default:
                    break;
            }
        }while(opcion!=3);
        sc.close();
    }
    
}
