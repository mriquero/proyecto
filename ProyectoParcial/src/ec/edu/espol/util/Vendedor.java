/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import ec.edu.espol.provider.Mail;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author macbookpro
 */
public class Vendedor extends Usuario {
    
    private Vehiculo v;
    private ArrayList<Venta> ventas;
 
    public Vendedor(String nom, String ap, String ci,String corr, String org, String us, String cl) {
        super(nom, ap, ci,corr, org, us, cl);
        
         ventas = new ArrayList<>();
    }

    
    // Retornará falso si la lista no contiene los atributos. 
    // Si contiene al menos uno --> retorna verdadero y ya no sería único.
    public boolean validarRegistro(String archivo)
    {
        ArrayList<String> atributos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(archivo)))
        {
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String arr[] = linea.split(",");
                String correoRe = arr[2];
                String usuarioRe = arr[4];
                atributos.add(correoRe);
                atributos.add(usuarioRe);   
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
        
        return atributos.contains(this.usuario) || atributos.contains(this.correo);
    }
    
    public void registrarVendedor(String archivo)
    {
        try(FileWriter fw = new FileWriter(archivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter addTxt = new PrintWriter(bw))
        {
            addTxt.println(this.toString());
        }
        catch (Exception v)
        {
            System.out.println(v.getMessage());
        }
    }
    
    public boolean validarPlaca(String placa, String archivo)
    {
        ArrayList<String> placas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(archivo)))
        {
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String arr[] = linea.split(",");
                String plac = arr[0];
                placas.add(plac);
                
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("No se encontró este archivo");
        }
        
        return placas.contains(placa);
        
    }
    // El vendedor llama al método ingresaTipo
    // Va a pedir ingreso por consola
    // Retorna objeto vehiculo para usarlo en el método registrarVehiculo
     public Vehiculo ingresaTipo()
    {
        System.out.println("Ingrese el tipo de vehiculo que quisiera ingresar, puede ser auto, camioneta, camión o moto:");
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        String tipo = input.next();
        System.out.println("Ingresa placa: ");
        String placa = input.next();
        System.out.println("Ingresa marca: ");
        String marca = input.next();
        System.out.println("Ingresa motor: ");
        String motor = input.next();
        System.out.println("Ingresa año: ");
        int año = input.nextInt();
        System.out.println("Ingresa recorrido: ");
        double recorrido = input.nextDouble();
        System.out.println("Ingresa color: ");
        String color = input.next();
        System.out.println("Ingresa combustible: ");
        String combustible = input.next();
        System.out.println("Ingresa precio: ");
        double precio = input.nextDouble();
        System.out.println("Ingresa transmision: ");
        String transmision = input.next();
        if(tipo.equals("auto") || tipo.equals("camioneta") || tipo.equals("camion"))
        {
            System.out.println("Ingresa cantidad ventanas: ");
            int ventanas = input.nextInt();
            
            if(tipo.equals("auto"))
            {
                Vehiculo v = new Auto(tipo,placa,marca,motor,año,recorrido,color,combustible,precio,transmision,ventanas);  
            }
            
            else if(tipo.equals("camioneta"))
            {
                Vehiculo v = new Camioneta(tipo,placa,marca,motor,año,recorrido,color,combustible,precio,transmision,ventanas);
            }  
            
            else if(tipo.equals("camion"))
            {
                Vehiculo v = new Camioneta(tipo,placa,marca,motor,año,recorrido,color,combustible,precio,transmision,ventanas);
            }   
        }
        
        else if(tipo.equals("moto"))
        {
           Vehiculo v = new Motocicleta(tipo,placa,marca,motor,año,recorrido,color,combustible,precio,transmision); 
        }
        return v;
             
    }
     
     
     // El vendedor llama a registrar vehiculo y envía el objeto obtenido en ingresaTipo().
     // Se guarda en una variable Vehiculo v = ingresaTipo().
     public void registrarVehiculo(Vehiculo o)
     {
         try(FileWriter fw = new FileWriter(o.getTipoVehiculo()+".txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            if(validarPlaca(o.getPlaca(),o.getTipoVehiculo()+".txt") == false)
                out.println(o.toString());
            else
                System.out.println("Ya existe esa placa registrada.");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }  
     }
     
     public static void eliminarVehiculo(Venta venta)
     {
         String placa = venta.getVehiculo().getPlaca();
         String tipo = venta.getVehiculo().getTipoVehiculo();
         ArrayList<String> datos = new ArrayList<>();
         File tipos = new File(tipo+".txt");
         
         try(Scanner sc = new Scanner(tipos);
                 FileWriter fw = new FileWriter(tipo+".txt",true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw))
                 
         {
             while(sc.hasNextLine())
             {
                 String linea = sc.nextLine();
                 String arr[] = linea.split(",");
                 String plak = arr[1];
                 if(plak != placa)
                 {
                     datos.add(linea);
                 }
             }
             
             tipos.delete();
             for(String linea: datos)
             {
                 out.println(linea);
             }
                   
         }
         
         catch(Exception e)
         {
             System.out.println("No existe esa compra");
         }
     }
    public Venta aceptarOferta(Oferta oferta){
        Venta venta= new Venta(oferta.getPlacaVehiculo(), this, oferta);
        venta.setVendido(true);
        String destinatario = oferta.getCorreo();
        String asunto = "SE HA ACEPTADO SU OFERTA";
        String cuerpo = venta.toString();
        Mail.enviarMail(destinatario, asunto, cuerpo);
        return venta;
    }
    @Override
     public String toString()
     {
         return nombres + "," + apellidos + "," + cedula + "," + correo + "," + organizacion + "," + usuario + "," + clave;
     }          
}