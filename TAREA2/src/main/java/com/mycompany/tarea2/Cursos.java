/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2;

/**
 *
 * @author 56977
 */
public class Cursos {
    private char Curso;
    private int numeroCurso;
    private int cantidadAlumno;
    
    float[] arregloCurso=new float[10];
    
    public char getCurso(){
        return Curso;
    }
    
    public int getnumeroCurso(){
        return numeroCurso;
    }
    
    public int getcantidadAlumno(){
        return cantidadAlumno;
    }

    public void setCurso(char Curso){
        this.Curso=Curso;
    }
    
    public void setnumeroCurso(int numeroCurso){
        this.numeroCurso=numeroCurso;
    }
    
    public void setcantidadAlumno(int cantidadAlumno){
        this.cantidadAlumno=cantidadAlumno;
    }
    
    public float MenorPromedio(){
        float menor=arregloCurso[0], actual;
        
        for(int i=1;i<arregloCurso.length;i++){
            actual=arregloCurso[i];
            if(actual<menor){
                menor=arregloCurso[i];
            } 
        }
        return menor;
    }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
}
