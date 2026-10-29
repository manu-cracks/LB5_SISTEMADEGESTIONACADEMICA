package com.academico.domain.event;

/**
 * Observador concreto que simula el envío de alertas o correos electrónicos
 * cada vez que ocurre un evento en el sistema.
 * Representa un canal de notificación externo que se suscribe al EventManager.
 */
public class NotificacionObserver implements Observer {

    @Override
    public void onEvent(Evento event) {
        String mensaje = String.format("[NOTIFICACIÓN] Enviando alerta/correo por evento: %s", event.getTipo());
        System.out.println(mensaje);
        // En un escenario real, aquí se conectaría a un servicio de correo o sistema de alertas.
    }
}