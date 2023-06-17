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
public class Peon extends Pieza {
    
    public Peon(int x, int y, Color color) {
        super(x,y,color);
    }

    public Peon(Color color){
        super(color);
    }

    
   
    @Override
    public boolean esMovimientoLegal(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = destinoX - origenX;
        int deltaY = destinoY - origenY;

        if (getColor().equals("blanco")) {
            if (origenX == 1 && deltaX == 2 && deltaY == 0 && tablero.getPiezaEnPosicion(2, origenY) == null) {
                return true; // Movimiento inicial de dos pasos hacia adelante permitido
            }
            if (deltaX == 1 && deltaY == 0 && tablero.getPiezaEnPosicion(destinoX, destinoY) == null) {
                return true; // Movimiento de un paso hacia adelante permitido
            }
            if (deltaX == 1 && Math.abs(deltaY) == 1 && tablero.getPiezaEnPosicion(destinoX, destinoY) != null) {
                return true; // Captura diagonal permitida
            }
        } else {
            if (origenX == 6 && deltaX == -2 && deltaY == 0 && tablero.getPiezaEnPosicion(5, origenY) == null) {
                return true; // Movimiento inicial de dos pasos hacia adelante permitido
            }
            if (deltaX == -1 && deltaY == 0 && tablero.getPiezaEnPosicion(destinoX, destinoY) == null) {
                return true; // Movimiento de un paso hacia adelante permitido
            }
            if (deltaX == -1 && Math.abs(deltaY) == 1 && tablero.getPiezaEnPosicion(destinoX, destinoY) != null) {
                return true; // Captura diagonal permitida
            }
        }

        return false; // Movimiento inválido
    }
    
    // Implementación de setX() y setY() para Peon
    
    public void setX(int x) {
        if (x >= 0 && x < 8) {
            super.setX(x);
        }
    }

    
    public void setY(int y) {
        if (y >= 0 && y < 8) {
            super.setY(y);
        }
    }
    
    
    public boolean esMovimientoLegal(int xDestino, int yDestino, Tablero tablero) {
        int xActual = getX();
        int yActual = getY();

        // Movimiento hacia adelante
        if (getColor() == Color.WHITE) {
            if (xDestino == xActual && yDestino == yActual - 1 && tablero.getPosicion(xDestino, yDestino) == null) {
                return true;
            }
            if (xDestino == xActual && yDestino == yActual - 2 && yActual == 6 && tablero.getPosicion(xDestino, yDestino) == null && tablero.getPosicion(xDestino, yDestino + 1) == null) {
                return true;
            }
        } else {
            if (xDestino == xActual && yDestino == yActual + 1 && tablero.getPosicion(xDestino,yDestino) == null) {
                return true;
            }
            if (xDestino == xActual && yDestino == yActual + 2 && yActual == 1 && tablero.getPosicion(xDestino, yDestino) == null && tablero.getPosicion(xDestino, yDestino - 1) == null) {
                return true;
            }
        }

        // Captura en diagonal
        if (getColor() == Color.WHITE) {
            if ((xDestino == xActual - 1 || xDestino == xActual + 1) && yDestino == yActual - 1 && tablero.getPosicion(xDestino, yDestino) != null && tablero.getPosicion(xDestino, yDestino).getColor() == Color.BLACK) {
                return true;
            }
        } else {
            if ((xDestino == xActual - 1 || xDestino == xActual + 1) && yDestino == yActual + 1 && tablero.getPosicion(xDestino, yDestino) != null && tablero.getPosicion(xDestino, yDestino).getColor() == Color.WHITE) {
                return true;
            }
        }

        return false;
    }
    @Override
    public boolean puedeMoverse(int origenX, int origenY, int destinoX, int destinoY, Tablero tablero) {
        int deltaX = Math.abs(destinoX - origenX);
        int deltaY = Math.abs(destinoY - origenY);

        // Verificar si es el primer movimiento
        if (!getHaMovido()) {
            if (getColor().equals(Color.WHITE)) {
                // Primer movimiento del peón blanco
                if (origenX == destinoX && deltaY <= 2) {
                    if (destinoY - origenY == 2 && tablero.getPiezaEnPosicion(origenX, origenY + 1) == null) {
                        return tablero.getPiezaEnPosicion(destinoX, destinoY) == null;
                    }
                    return deltaY == 1 && tablero.getPiezaEnPosicion(destinoX, destinoY) == null;
                }
            } else if (getColor().equals(Color.BLACK)) {
                // Primer movimiento del peón negro
                if (origenX == destinoX && deltaY <= 2) {
                    if (origenY - destinoY == 2 && tablero.getPiezaEnPosicion(origenX, origenY - 1) == null) {
                        return tablero.getPiezaEnPosicion(destinoX, destinoY) == null;
                    }
                    return deltaY == 1 && tablero.getPiezaEnPosicion(destinoX, destinoY) == null;
                }
            }
        } else {
            // Movimiento normal del peón
            if (getColor().equals(Color.WHITE)) {
                if (origenX == destinoX && deltaY == 1) {
                    return tablero.getPiezaEnPosicion(destinoX, destinoY) == null;
                }
            } else if (getColor().equals(Color.BLACK)) {
                if (origenX == destinoX && deltaY == 1) {
                    return tablero.getPiezaEnPosicion(destinoX, destinoY) == null;
                }
            }
        }

        // Movimiento diagonal para captura
        if (getColor().equals(Color.WHITE)) {
            if (deltaX == 1 && deltaY == 1 && tablero.getPiezaEnPosicion(destinoX, destinoY) != null && !tablero.getPiezaEnPosicion(destinoX, destinoY).getColor().equals(getColor())) {
                return true;
            }
        } else if (getColor().equals(Color.BLACK)) {
            if (deltaX == 1 && deltaY == 1 && tablero.getPiezaEnPosicion(destinoX, destinoY) != null && !tablero.getPiezaEnPosicion(destinoX, destinoY).getColor().equals(getColor())) {
                return true;
            }
        }

        return false; // Movimiento inválido
    }

    
    public boolean debePromocionarse(int x) {
        return true; // El peón siempre debe promocionarse
    }

    
}

