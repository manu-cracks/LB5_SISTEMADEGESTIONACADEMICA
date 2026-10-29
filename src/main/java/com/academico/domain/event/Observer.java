package com.academico.domain.event;

/**
 * Interfaz base del patrón Observer.
 * Define el contrato para que los observadores puedan suscribirse y recibir notificaciones.
 */
public interface Observer {
    /**
     * Método que se invoca cuando ocurre un evento notificado.
     * @param event El evento que se ha disparado.
     */
    void onEvent(Evento event);
}