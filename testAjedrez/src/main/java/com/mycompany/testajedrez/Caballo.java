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
public class Caballo extends Pieza {
     public Caballo(int x, int y, Color color) {
        super(x,y,color);
    }

   public Caballo(Color color){
        super(color);
    }
     
    @Override
    public boolean esMovimientoLegal(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = Math.abs(destinoX - origenX);
        int deltaY = Math.abs(destinoY - origenY);

        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }

    public boolean puedeMoverse(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = Math.abs(destinoX - origenX);
        int deltaY = Math.abs(destinoY - origenY);

        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }
    
    public boolean esMovimientoLegal(int xDestino, int yDestino, Tablero tablero) {
        int xActual = getX();
        int yActual = getY();

        int dx = Math.abs(xDestino - xActual);
        int dy = Math.abs(yDestino - yActual);

        // Movimiento en forma de "L"
        if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
            Pieza piezaDestino = tablero.getPosicion(xDestino, yDestino);
            return piezaDestino == null || !piezaDestino.getColor().equals(getColor());
        }

        return false; // Movimiento no válido
    }

    
    public boolean debePromocionarse(int x) {
        return false;
    }
}
