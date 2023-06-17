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
public class Torre extends Pieza {
    public Torre(int x, int y,Color color) {
        super(x,y,color);
    }

    public Torre(Color color){
        super(color);
    }

    
    @Override
    public boolean esMovimientoLegal(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        if (origenX == destinoX && origenY == destinoY) {
            return false; // No se ha movido la torre
        }

        if (origenX == destinoX) {
            // Movimiento vertical
            int minY = Math.min(origenY, destinoY);
            int maxY = Math.max(origenY, destinoY);
            for (int y = minY + 1; y < maxY; y++) {
                if (tablero.getPiezaEnPosicion(origenX, y) != null) {
                    return false; // Hay piezas en el camino
                }
            }
            return true;
        }

        if (origenY == destinoY) {
            // Movimiento horizontal
            int minX = Math.min(origenX, destinoX);
            int maxX = Math.max(origenX, destinoX);
            for (int x = minX + 1; x < maxX; x++) {
                if (tablero.getPiezaEnPosicion(x, origenY) != null) {
                    return false; // Hay piezas en el camino
                }
            }
            return true;
        }

        return false; // Movimiento inválido
    }
    
    public boolean esMovimientoLegal(int xDestino, int yDestino, Tablero tablero) {
        int xActual = getX();
        int yActual = getY();

        // Movimiento vertical
        if (xDestino == xActual && yDestino != yActual) {
            int inicio = Math.min(yActual, yDestino);
            int fin = Math.max(yActual, yDestino);
            for (int y = inicio + 1; y < fin; y++) {
                if (tablero.getPosicion(xDestino, y) != null) {
                    return false; // Hay una pieza bloqueando el movimiento
                }
            }
            return true;
        }

        // Movimiento horizontal
        if (yDestino == yActual && xDestino != xActual) {
            int inicio = Math.min(xActual, xDestino);
            int fin = Math.max(xActual, xDestino);
            for (int x = inicio + 1; x < fin; x++) {
                if (tablero.getPosicion(x, yDestino) != null) {
                    return false; // Hay una pieza bloqueando el movimiento
                }
            }
            return true;
        }

        return false; // Movimiento no válido
    }
    
     public boolean puedeMoverse(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = destinoX - origenX;
        int deltaY = destinoY - origenY;

        if (deltaX == 0 && deltaY != 0) {
            int direccion = deltaY > 0 ? 1 : -1;
            for (int i = origenY + direccion; i != destinoY; i += direccion) {
                if (tablero.getPiezaEnPosicion(origenX, i) != null) {
                    return false;
                }
            }
            return tablero.getPiezaEnPosicion(destinoX, destinoY) == null
                    || !tablero.getPiezaEnPosicion(destinoX, destinoY).getColor().equals(getColor());
        } else if (deltaX != 0 && deltaY == 0) {
            int direccion = deltaX > 0 ? 1 : -1;
            for (int i = origenX + direccion; i != destinoX; i += direccion) {
                if (tablero.getPiezaEnPosicion(i, origenY) != null) {
                    return false;
                }
            }
            return tablero.getPiezaEnPosicion(destinoX, destinoY) == null
                    || !tablero.getPiezaEnPosicion(destinoX, destinoY).getColor().equals(getColor());
        }

        return false;
    }
     
    public boolean debePromocionarse(int x) {
        return false; // La torre no requiere promoción
    }
}


