/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyecto1;

import java.util.Date;

/**
 *
 * @author 56977
 */
public class Chofer {
    
    private int IdChofer;
    private String Nombre;
    //private int numeroMicro;
    private Date FechaInicio;
    //el año parte de 1900(año,mes,dia,hora,minuto,seg)https://www.discoduroderoer.es/clase-date-de-java/
    private Date FechaTermino;

    public Chofer(int IdChofer, String Nombre, Date FechaInicio, Date FechaTermino) {
        this.IdChofer = IdChofer;
        this.Nombre = Nombre;
        this.FechaInicio = FechaInicio;
        this.FechaTermino = FechaTermino;
    }

    
    

    public String getNombre() {
        return Nombre;
    }

    public int getIdChofer() {
        return IdChofer;
    }
    
    public Date getFechaInicio() {
        return FechaInicio;
    }

    public Date getFechaTermino() {
        return FechaTermino;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setIdChofer(int IdChofer) {
        this.IdChofer = IdChofer;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public void setFechaTermino(Date FechaTermino) {
        this.FechaTermino = FechaTermino;
    }
      
}
