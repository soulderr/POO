/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testajedrez;

import java.awt.Color;

/**
 *
 * @author 56977
 */
public abstract class Pieza {
    private int x;
    private int y;
    private Color color;
    private boolean haMovido;

    public Pieza(Color color) {
        this.color = color;
    }
    
    public Pieza(int x, int y,Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.haMovido = false;
    }

    public Color getColor() {
        return color;
    }

    public boolean getHaMovido() {
        return haMovido;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHaMovido(boolean haMovido) {
        this.haMovido = haMovido;
    }
    
    

    public abstract boolean esMovimientoLegal(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero);
    
    protected boolean esMovimientoPermitido(int xDestino, int yDestino, Tablero tablero) {
        Pieza piezaDestino = tablero.getPosicion(xDstino, yDestino);

        if (piezaDestino == null) {
            return true; // Movimiento a una posición vacía permitido
        }

        return !piezaDestino.getColor().equals(getColor()); // Movimiento a una posición ocupada por una pieza de otro color permitido
    }
    
    public boolean puedeMoverse(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        if (!esMovimientoLegal(origenX, origenY, destinoX, destinoY, tablero)) {
            return false; // El movimiento no es legal para la pieza
        }
        
        Pieza piezaDestino = tablero.getPiezaEnPosicion(destinoX, destinoY);
        if (piezaDestino != null && piezaDestino.getColor().equals(getColor())) {
            return false; // Hay una pieza del mismo color en el destino
        }
        
        return true;
    }
    
    public boolean puedeMoverseSinPonerseEnJaque(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        Tablero tableroCopia = new Tablero(tablero); // Copia del tablero actual
        
        tableroCopia.moverPieza(origenX, origenY, destinoX, destinoY, color); // Simular el movimiento
        
        if (tableroCopia.estaEnJaque(getColor())) {
            return false; // El movimiento pone al rey en jaque
        }
        
        return true;
    }

    boolean haMovido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
