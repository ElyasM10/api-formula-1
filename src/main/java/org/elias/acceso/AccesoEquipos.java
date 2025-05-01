package org.elias.acceso;


import java.util.List;

import org.elias.modelo.Equipos;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AccesoEquipos  implements PanacheRepositoryBase<Equipos, Integer> {


    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Equipos> obtenerEquipos() {
        return listAll();
    }

    public Equipos obtenerEquipoPorId(Integer id) {
        return findById(id);
    }

}