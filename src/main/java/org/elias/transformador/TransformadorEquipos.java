package org.elias.transformador;


import org.elias.modelo.Equipos;
import org.elias.transferible.TransferibleEquipos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "jakarta")
public interface TransformadorEquipos {
    @Mapping(source = "nombre", target = "nombre")
    TransferibleEquipos entidadATransferible(Equipos equipos);
    @Mapping(source = "nombre", target = "nombre")
    List<TransferibleEquipos> toDTOList(List<Equipos> equipos);
}
