package org.elias.servicio;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.elias.acceso.AccesoEquipos;
import org.elias.transferible.TransferibleEquipos;
import org.elias.transformador.TransformadorEquipos;

import java.util.List;

@ApplicationScoped
public class ServicioEquipos {

    @Inject
    AccesoEquipos acceso;

    @Inject
    TransformadorEquipos transformador;

    public List<TransferibleEquipos> obtenerTodosLosEquipos(){


     List<TransferibleEquipos> transferible = transformador.toDTOList(acceso.obtenerEquipos());

     return transferible;
    }

}
