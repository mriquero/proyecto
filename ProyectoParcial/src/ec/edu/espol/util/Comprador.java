package ec.edu.espol.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author macbookpro
 */
public class Comprador extends Usuario {
    protected ArrayList<Registros> registrosCompr;
    private ArrayList<Oferta> ofertas;
    public Comprador(String nombres, String apellidos, String ci, String correo, String organizacion, String usuario, String clave )
    {
        super(nombres,apellidos, ci,correo,organizacion,usuario,clave);
        this.registrosCompr=new ArrayList<>();
        ofertas= new ArrayList<>();
    }
    
    public static void CrearDoc(){
        try{
            String archivo="Compradores.txt";
            PrintWriter archCompr= new PrintWriter(archivo);
            archCompr.close();
        }catch(Exception v){
            System.out.println(v.getMessage());
        }
    }
   
    // Retornará falso si la lista no contiene los atributos. 
    // Si contiene al menos uno --> retorna verdadero y ya no sería único.
    
    public boolean validarRegistro(String archivo) throws FileNotFoundException
    {
        ArrayList<String> atributos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(archivo)))
        {
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String arr[] = linea.split(",");
                String correoRe = arr[3];
                String usuarioRe = arr[4];
                atributos.add(correoRe);
                atributos.add(usuarioRe);   
            }
        }        
        return atributos.contains(this.usuario) || atributos.contains(this.correo);
    }
    public void registrarComprador(String archivo)
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
    public Oferta ofertar(Vehiculo vehiculo, double precioOfertado){
        Oferta oferta = new Oferta(this, vehiculo, precioOfertado);
        ofertas.add(oferta);
        return oferta;
    }

    @Override
    public String toString() {
        //Comprador, nombre, apeelido, correo, organiz,usuario,clave
        return "Comprador"+","+ this.nombres +"," + this.apellidos+","+ this.correo+", "+ this.organizacion+ ","+ this.usuario+","+this.clave;
    }
    
    
}
