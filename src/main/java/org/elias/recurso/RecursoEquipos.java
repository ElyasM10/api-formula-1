package org.elias.recurso;


import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.elias.servicio.ServicioEquipos;
import org.elias.transferible.TransferibleEquipos;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retorna el equipo correspondiente al id")
    @APIResponse(
            responseCode = "200",
            description = "Equipo recuperado con éxito.")
    @APIResponse(
            responseCode = "409",
            description = "Problemas al recuperar el equipo. Revisar cabecera 'Warning.'")
    @APIResponse(
            responseCode = "500",
            description = "Problemas internos al recuperar el equipo. Revisar cabecera 'Warning.'")
    @GET
    @Path("{id}")
    public RestResponse<TransferibleEquipos> obtenerBarrioporCodigo(@PathParam("id") Integer id){
        auditor.info("");
        auditor.info("INICIO DE NUEVA REQUEST");
        auditor.info("Intentando obtener equipo por id ");
        return  RestResponse.status(RestResponse.Status.CREATED,servicio.obtenerEquipoPorId(id));
    }

}
