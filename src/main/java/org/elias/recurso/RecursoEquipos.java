package org.elias.recurso;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.elias.servicio.ServicioEquipos;
import org.elias.transferible.TransferibleEquipos;
import org.jboss.logging.Logger;
import java.util.List;

@Path("/equipos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Tag(name = "Equipos")
public class RecursoEquipos {

    @Inject
    ServicioEquipos servicio;

    @Inject
    Logger auditor;

    @Operation(summary = "Devuelve todos los equipos")
    @APIResponse(responseCode = "200", description = "Operacion realizada con exito")
    @APIResponse(responseCode = "204", description = "No hay equipos")
    @GET
    public Response obtenerEquipos() {

        List<TransferibleEquipos> transferible = servicio.obtenerTodosLosEquipos();
        auditor.debug("Total de equipos " + transferible.size());
        return Response.ok(transferible).build();
    }

}
