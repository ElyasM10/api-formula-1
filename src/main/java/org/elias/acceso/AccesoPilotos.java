package org.elias.acceso;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.elias.modelo.Pilotos;

import java.util.List;

@ApplicationScoped
public class AccesoPilotos  implements PanacheRepositoryBase<Pilotos, Integer> {

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Pilotos> obtenerPilotos() {
        return listAll();
    }

}
