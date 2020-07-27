/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author macbookpro
 */
public class Usuario {
    protected String nombres, apellidos, cedula, correo, organizacion, usuario, clave;
    
    public Usuario(String nom, String ap, String ci, String corr, String org, String us, String cl)
    {
        nombres = nom;
        apellidos = ap;
        cedula=ci;
        correo = corr;
        organizacion = org;
        usuario = us;
        clave = cl;
    }
    public static boolean validarIngreso(String archivo,String usuario,String clave)
    {
       ArrayList<String> validar = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(archivo)))
        {
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String arr[] = linea.split(",");
                String correoUs = arr[5];
                String usuarioCl = arr[6];
                validar.add(correoUs);
                validar.add(usuarioCl);   
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found");
        }
        
      return validar.contains(usuario) && validar.contains(clave);
    }
   
    

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {        //No se aplica setCedula ya que es una documentacion cuyo valor no varía.
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o==null)        
            return false;
        if (this==o)        
            return true;
        if (this.getClass()!= o.getClass())    
            return false;
        
        Usuario other = (Usuario)o;
        return Objects.equals(this.cedula, other.cedula);
    }

    @Override
    public String toString() {
        return nombres + "," + apellidos + "," + cedula + "," + correo + "," + organizacion + "," + usuario + "," + clave;
    }
    
}
