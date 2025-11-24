package org.iesalandalus.programacion.robot.modelo;

import org.iesalandalus.programacion.robot.vista.Consola;

public class Main {
    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 6);
        
        Consola.despedirse();
    }

    private static void ejecutarOpcion(int opcion) {
        if (opcion == 1) {
            controlarRobotDefecto();
        } else if (opcion == 2) {
            controlarRobotZona();
        } else if (opcion == 3) {
            controlarRobotZonaOrientacion();
        } else if (opcion == 4) {
            controlarRobotZonaOrientacionCoordenada();
        } else if (opcion == 5) {
            ejecutarComando();
        } else if (opcion == 6) {
            System.out.println("Saliendo...");
        }
    }

    private static void controlarRobotDefecto() {
        Robot robot = new Robot();
        controladorRobot = new ControladorRobot(robot);
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controlarRobotZona() {
        Zona zona = Consola.elegirZona();
        Robot robot = new Robot(zona);
        controladorRobot = new ControladorRobot(robot);
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controlarRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Robot robot = new Robot(zona, orientacion);
        controladorRobot = new ControladorRobot(robot);
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        try {
            Zona zona = Consola.elegirZona();
            Orientacion orientacion = Consola.elegirOrientacion();
            Coordenada coordenada = Consola.elegirCoordenada();
            Robot robot = new Robot(zona, orientacion, coordenada);
            controladorRobot = new ControladorRobot(robot);
            Consola.mostrarRobot(controladorRobot);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void ejecutarComando() {
        if (controladorRobot == null) {
            System.out.println("No hay ningún robot para controlar.");
            return;
        }
        
        try {
            char comando = Consola.elegirComando();
            controladorRobot.ejecutar(comando);
            Consola.mostrarRobot(controladorRobot);
        } catch (RobotExcepcion e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}