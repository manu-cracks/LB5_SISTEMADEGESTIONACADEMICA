package com.academico.application.service;

import com.academico.application.port.in.EstudianteUseCase;
import com.academico.domain.event.EstudianteRegistradoEvent;
import com.academico.domain.event.EventManager;
import com.academico.domain.model.Estudiante;
import com.academico.domain.repository.EstudianteRepository;

import java.util.List;

public class EstudianteService implements EstudianteUseCase {

    private final EstudianteRepository repository;
    private final EventManager eventManager;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
        this.eventManager = new EventManager();
    }

    public EstudianteService(EstudianteRepository repository, EventManager eventManager) {
        this.repository = repository;
        this.eventManager = eventManager;
    }

    @Override
    public void registrar(Estudiante estudiante) {
        repository.guardar(estudiante);
        // Disparar evento de observador después de registrar
        EstudianteRegistradoEvent evento = new EstudianteRegistradoEvent(estudiante);
        eventManager.notificar(evento);
    }

    @Override
    public List<Estudiante> listar() {
        return repository.listar();
    }

    @Override
    public boolean actualizar(Estudiante estudiante) {
        return repository.actualizar(estudiante);
    }

    @Override
    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }
}