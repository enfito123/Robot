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
            ejecutarComandos();
        } else if (opcion == 6) {
            System.out.println("Saliendo...");
        }
    }

    private static void controlarRobotDefecto() {
        System.out.println("\n=== CREANDO ROBOT POR DEFECTO ===");
        Robot robot = new Robot();
        controladorRobot = new ControladorRobot(robot);
        System.out.println("Robot creado:");
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controlarRobotZona() {
        System.out.println("\n=== CREANDO ROBOT CON ZONA PERSONALIZADA ===");
        Zona zona = Consola.elegirZona();
        Robot robot = new Robot(zona);
        controladorRobot = new ControladorRobot(robot);
        System.out.println("Robot creado:");
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controlarRobotZonaOrientacion() {
        System.out.println("\n=== CREANDO ROBOT CON ZONA Y ORIENTACIÓN ===");
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Robot robot = new Robot(zona, orientacion);
        controladorRobot = new ControladorRobot(robot);
        System.out.println("Robot creado:");
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        System.out.println("\n=== CREANDO ROBOT COMPLETAMENTE PERSONALIZADO ===");
        try {
            Zona zona = Consola.elegirZona();
            Orientacion orientacion = Consola.elegirOrientacion();
            Coordenada coordenada = Consola.elegirCoordenada();
            Robot robot = new Robot(zona, orientacion, coordenada);
            controladorRobot = new ControladorRobot(robot);
            System.out.println("Robot creado:");
            Consola.mostrarRobot(controladorRobot);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void ejecutarComandos() {
        if (controladorRobot == null) {
            System.out.println("No hay ningún robot para controlar.");
            return;
        }
        
        System.out.println("\n=== MODO CONTROL CONTINUO ===");
        System.out.println("Comandos: W (avanzar), A (izquierda), D (derecha), M (volver al menú)");
        
        char comando;
        do {
            System.out.print("\nIntroduce comando: ");
            comando = Character.toUpperCase(Consola.elegirComando());
            
            if (comando == 'W' || comando == 'A' || comando == 'D') {
                try {
                    controladorRobot.ejecutar(comando);
                    Consola.mostrarRobot(controladorRobot);
                } catch (RobotExcepcion e) {
                    System.out.println("ERROR: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            } else if (comando == 'M') {
                System.out.println("Volviendo al menú principal...");
            } else {
                System.out.println("Comando no válido. Usa W, A, D o M.");
            }
            
        } while (comando != 'M');
    }
}