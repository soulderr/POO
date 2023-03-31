/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2;

/**
 *
 * @author 56977
 */
public class Alumno {
    private  String Nombre;
    private  int Rut;
    private  String Email;
    //private  float ArregloNotas[];
    
    float[] arregloNotas=new float[10];
    
    public String getNombre(){
        return Nombre;
    }
    public int getRut(){
        return Rut;
    }
    public String getEmail(){
        return Email;
    }
    
    
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    
    public void setRut(int Rut){
        this.Rut=Rut;
    }
    
    public void setEmail(String Email){
        this.Email=Email;
    }
    
    public float CalcularPromedio(){
        int cantidadNotas=0;
        float suma=0,promedio;
        
        for(int i=0;i<arregloNotas.length;i++){
            suma=suma + arregloNotas[i];
            cantidadNotas++;
        }
        
        return promedio=suma/cantidadNotas;
    }

    

    

    
}
