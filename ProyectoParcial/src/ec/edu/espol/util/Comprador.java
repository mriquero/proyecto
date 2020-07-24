/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Comprador(String nombres, String apellidos, String ci, String correo, String organizacion, String usuario, String clave)
    {
        super(nombres,apellidos, ci,correo,organizacion,usuario,clave);
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
                String correoRe = arr[2];
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
    
    
}
