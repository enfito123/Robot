package org.iesalandalus.programacion.robot.modelo;

public class Zona {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;
    private final int ancho;
    private final int alto;

    public Zona(int ancho, int alto) {
        if (!validarAncho(ancho)) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
        if (!validarAlto(alto)) {
            throw new IllegalArgumentException("Alto no válido.");
        }
        this.ancho = ancho;
        this.alto = alto;
    }

    public Zona() {
        this.ancho = ANCHO_MINIMO;
        this.alto = ALTO_MINIMO;
    }

    public int ancho() {
        return ancho;
    }

    public int alto() {
        return alto;
    }

    private boolean validarAncho(int ancho) {
        return ancho >= ANCHO_MINIMO && ancho <= ANCHO_MAXIMO;
    }

    private boolean validarAlto(int alto) {
        return alto >= ALTO_MINIMO && alto <= ALTO_MAXIMO;
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }
        return coordenada.x() >= 0 && coordenada.x() < ancho &&
                coordenada.y() >= 0 && coordenada.y() < alto;
    }

    private boolean perteneceX(int x) {
        return x >= 0 && x < ancho;
    }

    private boolean perteneceY(int y) {
        return y >= 0 && y < alto;
    }
}
