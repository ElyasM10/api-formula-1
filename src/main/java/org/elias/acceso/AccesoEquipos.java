package org.elias.acceso;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.elias.modelo.Equipos;


import java.util.List;

@ApplicationScoped
public class AccesoEquipos  implements PanacheRepositoryBase<Equipos, Integer> {


    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Equipos> obtenerEquipos() {
        return listAll();
    }

}