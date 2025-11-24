package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
    private Zona zona;
    private Orientacion orientacion;
    private Coordenada coordenada;

    public Robot() {
        this.zona = new Zona();
        this.orientacion = Orientacion.NORTE;
        this.coordenada = zona.getCentro();
    }

    public Robot(Zona zona) {
        setZona(zona);
        this.orientacion = Orientacion.NORTE;
        this.coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion) {
        setZona(zona);
        setOrientacion(orientacion);
        this.coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(coordenada);
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
    }

    public Robot(Robot robot) {
        if (robot == null) {
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.zona = robot.zona;
        this.orientacion = robot.orientacion;
        this.coordenada = robot.coordenada;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        if (zona == null) {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        if (orientacion == null) {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }
        this.coordenada = coordenada;
    }

    public void avanzar() {
        int newX = coordenada.x();
        int newY = coordenada.y();

        switch (orientacion) {
            case NORTE -> newY++;
            case SUR -> newY--;
            case ESTE -> newX++;
            case OESTE -> newX--;
            case NORESTE -> { newX++; newY++; }
            case NOROESTE -> { newX--; newY++; }
            case SURESTE -> { newX++; newY--; }
            case SUROESTE -> { newX--; newY--; }
        }

        Coordenada nuevaCoordenada = new Coordenada(newX, newY);
        if (!zona.pertenece(nuevaCoordenada)) {
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }
        this.coordenada = nuevaCoordenada;
    }

    public void girarALaDerecha() {
        if (orientacion == Orientacion.NORTE) {
            this.orientacion = Orientacion.NORESTE;
        } else if (orientacion == Orientacion.NORESTE) {
            this.orientacion = Orientacion.ESTE;
        } else if (orientacion == Orientacion.ESTE) {
            this.orientacion = Orientacion.SURESTE;
        } else if (orientacion == Orientacion.SURESTE) {
            this.orientacion = Orientacion.SUR;
        } else if (orientacion == Orientacion.SUR) {
            this.orientacion = Orientacion.SUROESTE;
        } else if (orientacion == Orientacion.SUROESTE) {
            this.orientacion = Orientacion.OESTE;
        } else if (orientacion == Orientacion.OESTE) {
            this.orientacion = Orientacion.NOROESTE;
        } else if (orientacion == Orientacion.NOROESTE) {
            this.orientacion = Orientacion.NORTE;
        }
    }

    public void girarALaIzquierda() {
        if (orientacion == Orientacion.NORTE) {
            this.orientacion = Orientacion.NOROESTE;
        } else if (orientacion == Orientacion.NOROESTE) {
            this.orientacion = Orientacion.OESTE;
        } else if (orientacion == Orientacion.OESTE) {
            this.orientacion = Orientacion.SUROESTE;
        } else if (orientacion == Orientacion.SUROESTE) {
            this.orientacion = Orientacion.SUR;
        } else if (orientacion == Orientacion.SUR) {
            this.orientacion = Orientacion.SURESTE;
        } else if (orientacion == Orientacion.SURESTE) {
            this.orientacion = Orientacion.ESTE;
        } else if (orientacion == Orientacion.ESTE) {
            this.orientacion = Orientacion.NORESTE;
        } else if (orientacion == Orientacion.NORESTE) {
            this.orientacion = Orientacion.NORTE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(zona, robot.zona) &&
                orientacion == robot.orientacion &&
                Objects.equals(coordenada, robot.coordenada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, orientacion, coordenada);
    }

    @Override
    public String toString() {
        return "Robot [zona=" + zona + ", orientación=" + orientacion + ", coordenada=" + coordenada + "]";
    }
}