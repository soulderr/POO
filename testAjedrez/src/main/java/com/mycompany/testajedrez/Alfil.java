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
public class Alfil extends Pieza {
    public Alfil(int x, int y, Color color) {
        super(x,y,color);
    }

    public Alfil(Color color){
        super(color);
    }

    @Override
    public boolean esMovimientoLegal(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = destinoX - origenX;
        int deltaY = destinoY - origenY;

        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            int direccionX = deltaX > 0 ? 1 : -1;
            int direccionY = deltaY > 0 ? 1 : -1;
            int x = origenX + direccionX;
            int y = origenY + direccionY;
            while (x != destinoX) {
                if (tablero.getPiezaEnPosicion(x, y) != null) {
                    return false;
                }
                x += direccionX;
                y += direccionY;
            }
            return tablero.getPiezaEnPosicion(destinoX, destinoY) == null
                    || !tablero.getPiezaEnPosicion(destinoX, destinoY).getColor().equals(getColor());
        }

        return false;
    }
    
    public boolean esMovimientoLegal(int xDestino, int yDestino, Tablero tablero) {
        int xActual = getX();
        int yActual = getY();

        int dx = Math.abs(xDestino - xActual);
        int dy = Math.abs(yDestino - yActual);

        // Movimiento en diagonal
        if (dx == dy) {
            int incX = (xDestino > xActual) ? 1 : -1;
            int incY = (yDestino > yActual) ? 1 : -1;

            int x = xActual + incX;
            int y = yActual + incY;

            while (x != xDestino && y != yDestino) {
                if (tablero.getPosicion(x, y) != null) {
                    return false; // Hay una pieza bloqueando el movimiento
                }
                x += incX;
                y += incY;
            }

            Pieza piezaDestino = tablero.getPosicion(xDestino, yDestino);
            return piezaDestino == null || !piezaDestino.getColor().equals(getColor());
        }

        return false; // Movimiento no válido
    }

    public boolean puedeMoverse(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = destinoX - origenX;
        int deltaY = destinoY - origenY;

        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            int direccionX = deltaX > 0 ? 1 : -1;
            int direccionY = deltaY > 0 ? 1 : -1;
            int x = origenX + direccionX;
            int y = origenY + direccionY;
            while (x != destinoX) {
                if (tablero.getPiezaEnPosicion(x, y) != null) {
                    return false;
                }
                x += direccionX;
                y += direccionY;
            }
            return tablero.getPiezaEnPosicion(destinoX, destinoY) == null
                    || !tablero.getPiezaEnPosicion(destinoX, destinoY).getColor().equals(getColor());
        }

        return false;
    }

    
    public boolean debePromocionarse(int x) {
        return false;
    }
}
