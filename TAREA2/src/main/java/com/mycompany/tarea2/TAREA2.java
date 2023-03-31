/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea2;

/**
 *
 * @author 56977
 */
public class TAREA2 {
    
     static Colegio colegio=new Colegio();

    public static void main(String[] args) {
        Cursos[]arregloCursos=colegio.cursosConAlumnosMenorPromedio();
        for (Cursos arregloCurso : arregloCursos){
             System.out.println("Id curso:"+arregloCurso.getId()+"");
         }
    }

    
}
