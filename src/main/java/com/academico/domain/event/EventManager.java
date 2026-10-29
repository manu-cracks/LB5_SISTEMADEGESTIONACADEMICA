package com.academico.domain.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de suscripciones que actúa como Subject (Sujeto) en el patrón Observer.
 * Mantiene una lista de observadores registrados y provee métodos para
 * suscribir, desuscribir y notificar a todos los observadores cuando ocurre un evento.
 */
public class EventManager {
    private final List<Observer> observadores;

    public EventManager() {
        this.observadores = new ArrayList<>();
    }

    /**
     * Suscribe un nuevo observador al gestor de eventos.
     * @param observer El observador a agregar.
     */
    public void suscribir(Observer observer) {
        if (observer != null && !observadores.contains(observer)) {
            observadores.add(observer);
        }
    }

    /**
     * Desuscribe un observador existente del gestor de eventos.
     * @param observer El observador a remover.
     */
    public void desuscribir(Observer observer) {
        observadores.remove(observer);
    }

    /**
     * Notifica a todos los observadores suscritos desencadenando el evento especificado.
     * @param event El evento a notificar.
     */
    public void notificar(Evento event) {
        for (Observer observer : observadores) {
            observer.onEvent(event);
        }
    }

    /**
     * Retorna el número actual de observadores registrados.
     * @return Count de observadores.
     */
    public int getNumObservadores() {
        return observadores.size();
    }
}