package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("--------------");
        System.out.println("1. Controlar robot por defecto");
        System.out.println("2. Controlar robot indicando zona");
        System.out.println("3. Controlar robot indicando zona y orientación");
        System.out.println("4. Controlar robot indicando zona, orientación y coordenada");
        System.out.println("5. Ejecutar comando");
        System.out.println("6. Salir");
    }

    public static int elegirOpcion() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            System.out.print("Elige una opción (1-6): ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

    public static Zona elegirZona() {
        Zona zona = null;
        do {
            try {
                System.out.print("Introduce el ancho de la zona: ");
                int ancho = Entrada.entero();
                System.out.print("Introduce el alto de la zona: ");
                int alto = Entrada.entero();
                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (zona == null);
        return zona;
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("ORIENTACIONES");
        System.out.println("-------------");
        System.out.println("1. Norte");
        System.out.println("2. Noreste");
        System.out.println("3. Este");
        System.out.println("4. Sureste");
        System.out.println("5. Sur");
        System.out.println("6. Suroeste");
        System.out.println("7. Oeste");
        System.out.println("8. Noroeste");
    }

    public static Orientacion elegirOrientacion() {
        int opcion;
        do {
            mostrarMenuOrientacion();
            System.out.print("Elige una orientación (1-8): ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 8);

        if (opcion == 1) {
            return Orientacion.NORTE;
        } else if (opcion == 2) {
            return Orientacion.NORESTE;
        } else if (opcion == 3) {
            return Orientacion.ESTE;
        } else if (opcion == 4) {
            return Orientacion.SURESTE;
        } else if (opcion == 5) {
            return Orientacion.SUR;
        } else if (opcion == 6) {
            return Orientacion.SUROESTE;
        } else if (opcion == 7) {
            return Orientacion.OESTE;
        } else {
            return Orientacion.NOROESTE;
        }
    }

    public static Coordenada elegirCoordenada() {
        System.out.print("Introduce la coordenada X: ");
        int x = Entrada.entero();
        System.out.print("Introduce la coordenada Y: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando() {
        System.out.print("Introduce el comando a ejecutar (A/D/I): ");
        return Entrada.caracter();
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        if (controladorRobot == null) {
            System.out.println("No hay ningún robot para mostrar.");
        } else {
            System.out.println(controladorRobot.getRobot());
        }
    }

    public static void despedirse() {
        System.out.println("¡Hasta luego! Gracias por usar el simulador de robot.");
    }
}