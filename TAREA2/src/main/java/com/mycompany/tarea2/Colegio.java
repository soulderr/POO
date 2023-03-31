/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2;

/**
 *
 * @author 56977
 */
public class Colegio {
    private String Nombre;
    private String NombreDirector;
    
    float[] arregloCursos=new float[10];
    
    public String getNombre(){
        return Nombre;
    }
    
    public String getNombreDirector(){
        return NombreDirector;
    }
    
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    
    public void setNombreDirector(String NombreDirector){
        this.NombreDirector=NombreDirector;
    }
    
    public float[] cursosConAlumnosMenorPromedio(){
        
        float aux;
        
        for(int i=0;i<arregloCursos.length;i++){
            for(int j=0;j<arregloCursos.length;j++){
                if(arregloCursos[i]>arregloCursos[i+1]){
                    aux=arregloCursos[i];
                    arregloCursos[i]=arregloCursos[i+1];
                    arregloCursos[i+1]=aux;
                }
            }
        }
        
        return arregloCursos;
        
    }
}
