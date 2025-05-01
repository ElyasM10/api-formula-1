package org.elias.servicio;

import java.util.List;

import org.elias.acceso.AccesoPilotos;
import org.elias.exception.HttpNoContentException;
import org.elias.modelo.Pilotos;
import org.elias.transferible.TransferiblePilotos;
import org.elias.transformador.TransformadorPilotos;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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

    public TransferiblePilotos obtenerPilotoPorId(Integer id) {
    auditor.info("Obteniendo el piloto: " + id);
    Pilotos resultado = acceso.obtenerPilotoPorId(id);

    if (resultado == null) {
        throw new HttpNoContentException("No existe el piloto con id: " + id);
    }

    TransferiblePilotos transferible = transformador.entidadATransferible(resultado);

    if (transferible.getId() == 0) {
        transferible.setId(null);
    }

    return transferible;
}

}
