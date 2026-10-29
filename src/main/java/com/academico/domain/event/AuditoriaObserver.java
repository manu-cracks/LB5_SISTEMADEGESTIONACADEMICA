package com.academico.domain.event;

/**
 * Observador concreto que registra logs cada vez que ocurre un evento en el sistema.
 * Simula la funcionalidad de auditoría al suscribirse a las notificaciones del EventManager.
 */
public class AuditoriaObserver implements Observer {

    @Override
    public void onEvent(Evento event) {
        String mensaje = String.format("[AUDITORIA] Evento registrado: %s - %s", event.getTipo(), event);
        System.out.println(mensaje);
        // En un escenario real, aquí se escribiría en un archivo de log o base de datos.
    }
}