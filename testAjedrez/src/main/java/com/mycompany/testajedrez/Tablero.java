/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testajedrez;

import java.awt.Color;
import java.util.ArrayList;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author 56977
 */
public class Tablero {
    private Pieza[][] tablero;
    private Object color;

    public Tablero() {
        tablero = new Pieza[8][8];
        inicializarTablero();
    }

    Tablero(Tablero tablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    private void inicializarTablero() {
        // Colocar piezas blancas
        tablero[0][0] = new Torre(Color.WHITE);
        tablero[0][1] = new Caballo(Color.WHITE);
        tablero[0][2] = new Alfil(Color.WHITE);
        tablero[0][3] = new Dama(Color.WHITE);
        tablero[0][4] = new Rey(Color.WHITE);
        tablero[0][5] = new Alfil(Color.WHITE);
        tablero[0][6] = new Caballo(Color.WHITE);
        tablero[0][7] = new Torre(Color.WHITE);
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(Color.WHITE);
        }

        // Colocar piezas negras
        tablero[7][0] = new Torre(Color.BLACK);
        tablero[7][1] = new Caballo(Color.BLACK);
        tablero[7][2] = new Alfil(Color.BLACK);
        tablero[7][3] = new Dama(Color.BLACK);
        tablero[7][4] = new Rey(Color.BLACK);
        tablero[7][5] = new Alfil(Color.BLACK);
        tablero[7][6] = new Caballo(Color.BLACK);
        tablero[7][7] = new Torre(Color.BLACK);
        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon(Color.BLACK);
        }
    }

     public boolean esPosicionValida(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public Pieza getPosicion(int x, int y) {
        if (esPosicionValida(x, y)) {
            return tablero[x][y];
        } else {
            return null;
        }
    }

    public void setPosicion(int x, int y, Pieza pieza) {
        if (esPosicionValida(x, y)) {
            tablero[x][y] = pieza;
        }
    }
    public boolean moverPieza(int xOrigen, int yOrigen, int xDestino, int yDestino, Color color) {
    Pieza piezaOrigen = getPosicion(xOrigen, yOrigen);
    Pieza piezaDestino = getPosicion(xDestino, yDestino);

    // Verificar si la posición de origen y destino son válidas y si hay una pieza en la posición de origen
    if (!esPosicionValida(xOrigen, yOrigen) || !esPosicionValida(xDestino, yDestino) || piezaOrigen == null) {
        return false;
    }

    // Verificar si la pieza de origen pertenece al color correcto
    if (!piezaOrigen.getColor().equals(color)) {
        return false;
    }

    // Verificar si el movimiento es legal para la pieza de origen
    if (!piezaOrigen.esMovimientoLegal(xOrigen, yOrigen, xDestino, yDestino, this)) {
        return false;
    }

    // Verificar si la posición de destino está ocupada por una pieza del mismo color
    if (piezaDestino != null && piezaDestino.getColor().equals(color)) {
        return false;
    }

    // Realizar el movimiento
    setPosicion(xOrigen, yOrigen, null); // Vaciar la posición de origen
    setPosicion(xDestino, yDestino, piezaOrigen); // Colocar la pieza de origen en la posición de destino

    // Actualizar la posición de la pieza
    piezaOrigen.setX(xDestino);
    piezaOrigen.setY(yDestino);

    return true;
    }

    public Pieza getPiezaEnPosicion(int x, int y) {
        return tablero[x][y];
    }

    public void dibujarTablero() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tablero[i][j];
                if (pieza != null) {
                    System.out.print(pieza.getSimbolo() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    boolean estaEnJaque(String color) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean estaEnJaque(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    ArrayList<Pieza> obtenerPiezasPorColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
