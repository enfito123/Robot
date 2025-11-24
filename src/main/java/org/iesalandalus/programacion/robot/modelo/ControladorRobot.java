package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {
    private Robot robot;

    public ControladorRobot(Robot robot) {
        if (robot == null) {
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) {
        char comandoMayuscula = Character.toUpperCase(comando);
        
        if (comandoMayuscula == 'A') {
            robot.avanzar();
        } else if (comandoMayuscula == 'D') {
            robot.girarALaDerecha();
        } else if (comandoMayuscula == 'I') {
            robot.girarALaIzquierda();
        } else {
            throw new IllegalArgumentException("Comando desconocido: " + comando);
        }
    }
}