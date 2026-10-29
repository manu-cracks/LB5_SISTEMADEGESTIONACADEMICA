package com.academico.domain.event;

import com.academico.domain.model.Estudiante;

/**
 * Evento que se dispara cuando un estudiante es registrado en el sistema.
 * Encapsula la información del estudiante para ser consumida por los observadores.
 */
public class EstudianteRegistradoEvent extends Evento {

    private final Estudiante estudiante;

    public EstudianteRegistradoEvent(Estudiante estudiante) {
        super("ESTUDIANTE_REGISTRADO");
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
}