package org.elias.acceso;

import java.util.List;

import org.elias.modelo.Pilotos;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AccesoPilotos  implements PanacheRepositoryBase<Pilotos, Integer> {

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Pilotos> obtenerPilotos() {
        return listAll();
    }

     public Pilotos obtenerPilotoPorId(Integer id) {
        return findById(id);
    }


}
