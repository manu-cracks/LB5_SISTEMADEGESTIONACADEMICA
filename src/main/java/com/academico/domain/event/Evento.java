package com.academico.domain.event;

/**
 * Clase base que representa un evento genérico en el patrón Observer.
 * Almacena el tipo de evento y proporciona la estructura base
 * para todos los eventos del sistema.
 */
public class Evento {
    private final String tipo;

    public Evento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Evento{" + "tipo='" + tipo + '\'' + '}';
    }
}