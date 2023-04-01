/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyecto1;

/**
 *
 * @author 56977
 */
public class Bus {
    
    private String Patente;
    private int Linea;    //numero del recorrido ej: 203
    private int Hora;
    private int Minutos;
    private int Segundos;
    private boolean Disponible;

    public String getPatente() {
        return Patente;
    }

    public int getLinea() {
        return Linea;
    }

    public int getHora() {
        return Hora;
    }

    public int getMinutos() {
        return Minutos;
    }

    public int getSegundos() {
        return Segundos;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setPatente(String Patente) {
        this.Patente = Patente;
    }

    public void setLinea(int Linea) {
        this.Linea = Linea;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }

    public void setMinutos(int Minutos) {
        this.Minutos = Minutos;
    }

    public void setSegundos(int Segundos) {
        this.Segundos = Segundos;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }
    
}
