package org.elias.servicio;


import java.util.List;

import org.elias.acceso.AccesoEquipos;
import org.elias.exception.HttpNoContentException;
import org.elias.modelo.Equipos;
import org.elias.transferible.TransferibleEquipos;
import org.elias.transformador.TransformadorEquipos;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServicioEquipos {

    @Inject
    AccesoEquipos acceso;

    @Inject
    TransformadorEquipos transformador;


    @Inject
    Logger auditor;

    public List<TransferibleEquipos> obtenerTodosLosEquipos(){


     List<TransferibleEquipos> transferible = transformador.toDTOList(acceso.obtenerEquipos());

        for (TransferibleEquipos equipo : transferible) {
            auditor.debug(equipo);
        }

     return transferible;
    }

      public TransferibleEquipos obtenerEquipoPorId (Integer id) {
        auditor.info("Obteniendo el equipo: " + id);
        Equipos resultado = acceso.obtenerEquipoPorId(id);

        if(resultado == null){
            throw new HttpNoContentException("No existe el equipo con id: "+id);
        }

        TransferibleEquipos transferible = transformador.entidadATransferible(resultado);

        if (transferible.getId()==0) {
            transferible.setId(null);
        }


        return  transferible;
    }

}
