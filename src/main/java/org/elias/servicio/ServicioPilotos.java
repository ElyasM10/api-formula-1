package org.elias.servicio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.elias.acceso.AccesoEquipos;
import org.elias.acceso.AccesoPilotos;
import org.elias.transferible.TransferibleEquipos;
import org.elias.transferible.TransferiblePilotos;
import org.elias.transformador.TransformadorEquipos;
import org.elias.transformador.TransformadorPilotos;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class ServicioPilotos {

    @Inject
    AccesoPilotos acceso;

    @Inject
    Logger auditor;

    @Inject
    TransformadorPilotos transformador;

    public List<TransferiblePilotos> obtenerTodosLosPilotos(){


        List<TransferiblePilotos> transferible = transformador.toDTOList(acceso.obtenerPilotos());

        for (TransferiblePilotos piloto : transferible) {
            auditor.debug(piloto);
        }


        return transferible;
    }

}
