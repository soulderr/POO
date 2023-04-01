/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avanceproyecto1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author 56977
 */
public class AvanceProyecto1 {
    
    public static String file = "src/test/datos.txt";
    public static ArrayList<Chofer> datos=new ArrayList<Chofer>();

    public static void main(String[] args) {
        leerDatos();
        mostrarDatos();
    }
    
    public static void leerDatos(){
        
        try {
            BufferedReader archivo = new BufferedReader(new FileReader(file));
            
            int i=0;
            String linea;
            String [] campos=new String[4];
            while ((linea = archivo.readLine()) != null){
                
                //System.out.println();
                if(i>0){
                   campos=linea.split(";");
                   Date fecha=(Date) new SimpleDateFormat("dd/mm/yyyy/hh/mm/ss").parse(campos[2]);
                   Date fecha1=(Date) new SimpleDateFormat("dd/mm/yyyy/hh/mm/ss").parse(campos[3]);
                   
                   datos.add(new Chofer(Integer.valueOf(campos[0]),campos[1],fecha,fecha1));
                    //tratamiento para separar los ';'
                }
                
                i++;
            }
             System.out.println(" ---------------------------");
             System.out.println("|                           |");
             System.out.println("| El tamaño de objetos es "+datos.size()+" |");
             System.out.println("|                           |");
             System.out.println(" ---------------------------");
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException | ParseException e){
        
        }
    }
    
     public static void mostrarDatos(){
         //Mostrardatos
         
         for(int i=0;i<datos.size();i++){
             System.out.println("El contenido del objeto "+ (i+1)+" es:");
             System.out.println("Id Chofer: "+ datos.get(i).getIdChofer());
             System.out.println("Nombre: "+ datos.get(i).getNombre());
             System.out.println("Fecha Inicio: "+datos.get(i).getFechaInicio());
             System.out.println("Fecha Termino: "+datos.get(i).getFechaTermino());
             System.out.println("");
             
         }
        
    }
}
