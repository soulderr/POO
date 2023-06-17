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
public class Rey extends Pieza {
    public Rey(int x, int y,Color color) {
        super(x,y,color);
    }

    public Rey(Color color){
        super(color);
    }

   
    @Override
    public boolean esMovimientoLegal(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = Math.abs(destinoX - origenX);
        int deltaY = Math.abs(destinoY - origenY);

        if (deltaX <= 1 && deltaY <= 1) {
            return true; // Movimiento en cualquier dirección de un paso
        }

        // Verificar el enroque
        if (!haMovido() && deltaY == 0 && Math.abs(destinoY - origenY) == 2) {
            if (destinoY > origenY) {
                // Enroque corto
                Pieza torre = tablero.getPiezaEnPosicion(origenX, 7);
                if (torre instanceof Torre && !torre.haMovido()) {
                    for (int y = origenY + 1; y <= destinoY - 1; y++) {
                        if (tablero.getPiezaEnPosicion(origenX, y) != null) {
                            return false; // Hay piezas en el camino
                        }
                    }
                    return true;
                }
            } else {
                // Enroque largo
                Pieza torre = tablero.getPiezaEnPosicion(origenX, 0);
                if (torre instanceof Torre && !torre.haMovido()) {
                    for (int y = origenY - 1; y >= destinoY + 1; y--) {
                        if (tablero.getPiezaEnPosicion(origenX, y) != null) {
                            return false; // Hay piezas en el camino
                        }
                    }
                    return true;
                }
            }
        }

        return false; // Movimiento inválido
    }

    public boolean puedeMoverse(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = Math.abs(destinoX - origenX);
        int deltaY = Math.abs(destinoY - origenY);

        return deltaX <= 1 && deltaY <= 1;
    }

    
    public boolean debePromocionarse(int x) {
        return false;
    }
    
    public boolean enroque(Tablero tablero, int origenX, int origenY, int destinoX, int destinoY) {
    if (!haMovido() && !tablero.estaEnJaque(getColor())) {
        // Enroque corto
        if (destinoY == 6) {
            Pieza torre = tablero.getPiezaEnPosicion(origenX, 7);
            if (torre instanceof Torre && !torre.haMovido()) {
                tablero.moverPieza(origenX, origenY, destinoX, destinoY); // Mover el rey
                tablero.moverPieza(origenX, 7, destinoX, 5); // Mover la torre
                return true;
            }
        }
        // Enroque largo
        else if (destinoY == 2) {
            Pieza torre = tablero.getPiezaEnPosicion(origenX, 0);
            if (torre instanceof Torre && !torre.haMovido()) {
                tablero.moverPieza(origenX, origenY, destinoX, destinoY); // Mover el rey
                tablero.moverPieza(origenX, 0, destinoX, 3); // Mover la torre
                return true;
            }
        }
    }
    return false;
    }
    
    public boolean esMovimientoLegal(int xDestino, int yDestino, Tablero tablero) {
        int xActual = getX();
        int yActual = getY();

        int dx = Math.abs(xDestino - xActual);
        int dy = Math.abs(yDestino - yActual);

        // Movimiento en cualquier dirección de una casilla
        if ((dx == 1 && dy == 0) || (dx == 0 && dy == 1) || (dx == 1 && dy == 1)) {
            Pieza piezaDestino = tablero.getPosicion(xDestino, yDestino);
            return piezaDestino == null || !piezaDestino.getColor().equals(getColor());
        }

        // Enroque (por implementar)

        return false; // Movimiento no válido
    }
}
