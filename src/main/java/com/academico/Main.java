package com.academico;

import com.academico.application.port.in.EstudianteUseCase;
import com.academico.application.service.EstudianteService;
import com.academico.domain.event.AuditoriaObserver;
import com.academico.domain.event.EventManager;
import com.academico.domain.event.NotificacionObserver;
import com.academico.domain.model.Estudiante;
import com.academico.domain.repository.EstudianteRepository;
import com.academico.infrastructure.adapter.out.persistence.EstudianteRepositoryJson;
import com.academico.infrastructure.adapter.out.persistence.EstudianteRepositoryPostgres;
import com.academico.presentation.EstudianteUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. Adaptador de salida: almacena en JSON
        EstudianteRepository repository = new EstudianteRepositoryJson();
        //EstudianteRepository repository = new EstudianteRepositoryPostgres();

        // 2. Nucleo de la aplicacion: caso de uso y gestor de eventos
        EventManager eventManager = new EventManager();

        // 3. Registrar observadores en el EventManager
        AuditoriaObserver auditoriaObserver = new AuditoriaObserver();
        NotificacionObserver notificacionObserver = new NotificacionObserver();

        eventManager.suscribir(auditoriaObserver);
        eventManager.suscribir(notificacionObserver);

        EstudianteService service = new EstudianteService(repository, eventManager);

        // presentacion
        EstudianteUI estudianteUI = new EstudianteUI(service);


        Scanner sc = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n=== SISTEMA DE GESTIÓN ACADÉMICA ===");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar cursos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    estudianteUI.mostrarMenu(sc);
                    break;

                case 2:
                    // CursoUI.mostrarMenu(sc);
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}