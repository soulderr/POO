/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testajedrez;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 56977
 */
public class Partida {
    private Tablero tablero;
    private Color turnoActual;
    private boolean partidaTerminada;

    public Partida() {
        tablero = new Tablero();
        turnoActual = Color.WHITE;
        partidaTerminada = false;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean partidaTerminada = false;
        
        while (!partidaTerminada) {
            
            System.out.println("Turno del jugador: " + turnoActual);

            tablero.dibujarTablero();

            System.out.print("Ingrese la posición de origen (fila columna): ");
            int origenX = scanner.nextInt();
            int origenY = scanner.nextInt();

            System.out.print("Ingrese la posición de destino (fila columna): ");
            int destinoX = scanner.nextInt();
            int destinoY = scanner.nextInt();

            if (realizarMovimiento(origenX, origenY, destinoX, destinoY)) {
                if (estaEnJaqueMate(obtenerColorContrario(turnoActual))) {
                    partidaTerminada = true;
                    System.out.println("¡Jaque mate! Ganador: " + turnoActual);
                } else {
                    cambiarTurno();
                }
            } else {
                System.out.println("Movimiento inválido. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    private boolean realizarMovimiento(int origenX, int origenY, int destinoX, int destinoY, Color color) {
        Pieza pieza = tablero.getPiezaEnPosicion(origenX, origenY);

        if (pieza != null && pieza.getColor() == turnoActual && pieza.puedeMoverse(origenX, origenY, destinoX, destinoY, tablero)) {
            tablero.moverPieza(origenX, origenY, destinoX, destinoY,color);
            return true;
        }

        return false;
    }

    private void cambiarTurno() {
        turnoActual = obtenerColorContrario(turnoActual);
    }

    private Color obtenerColorContrario(Color color) {
        return (color.equals(Color.WHITE)) ? Color.BLACK : Color.WHITE;
    }

    private boolean estaEnJaqueMate(Color color) {
        if (!tablero.estaEnJaque(color)) {
            return false; // El rey no está en jaque
        }

        ArrayList<Pieza> piezasPropias = tablero.obtenerPiezasPorColor(color);
        for (Pieza pieza : piezasPropias) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (pieza.puedeMoverse(x, y, x, y, tablero)) {
                        Tablero tableroCopia = new Tablero(tablero);
                        tableroCopia.moverPieza(x, y, x, y,color);
                        if (!tableroCopia.estaEnJaque(color)) {
                            return false; // Existe al menos un movimiento legal que evita el jaque mate
                        }
                    }
                }
            }
        }

        return true; // No hay movimientos legales para evitar el jaque mate
    }
    
}
