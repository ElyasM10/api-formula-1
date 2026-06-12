package org.elias.arranque;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.elias.acceso.AccesoPilotos;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ArranqueAplicacion {

    @Inject
    Logger log;

    @Inject
    AccesoPilotos acceso;

    void onStart(@Observes StartupEvent event) {
        try {
            acceso.obtenerPilotos();
            log.info("Base de datos disponible — conexión establecida correctamente.");
        } catch (Exception e) {
            log.error("Base de datos no disponible en localhost:5432 — se usarán datos de prueba.");
        }
    }
}
