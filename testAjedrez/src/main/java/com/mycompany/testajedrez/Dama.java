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
public class Dama extends Pieza {
    public Dama(int x, int y,Color color) {
        super(x,y,color);
    }

    public Dama(Color color){
        super(color);
    }

    
    @Override
    public boolean esMovimientoLegal(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
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
        } else if (Math.abs(deltaX) == Math.abs(deltaY)) {
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
        } else if (Math.abs(deltaX) == Math.abs(deltaY)) {
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

        // Verificar si el movimiento es similar al de una Torre
        if (xDestino == xActual || yDestino == yActual) {
            int inicio, fin;
            if (xDestino == xActual) {
                inicio = Math.min(yActual, yDestino);
                fin = Math.max(yActual, yDestino);
                for (int y = inicio + 1; y < fin; y++) {
                    if (tablero.getPosicion(xDestino, y) != null) {
                        return false; // Hay una pieza bloqueando el movimiento
                    }
                }
            } else {
                inicio = Math.min(xActual, xDestino);
                fin = Math.max(xActual, xDestino);
                for (int x = inicio + 1; x < fin; x++) {
                    if (tablero.getPosicion(x, yDestino) != null) {
                        return false; // Hay una pieza bloqueando el movimiento
                    }
                }
            }

            Pieza piezaDestino = tablero.getPosicion(xDestino, yDestino);
            return piezaDestino == null || !piezaDestino.getColor().equals(getColor());
        }

        // Verificar si el movimiento es similar al de un Alfil
        int dx = Math.abs(xDestino - xActual);
        int dy = Math.abs(yDestino - yActual);
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
    
    public boolean debePromocionarse(int x) {
        return false;
    }
}
