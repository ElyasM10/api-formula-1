package org.elias.transformador;

import org.elias.modelo.Equipos;
import org.elias.modelo.Pilotos;
import org.elias.transferible.TransferiblePilotos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface TransformadorPilotos {
    @Mapping(source = "nombre", target = "nombre")
    TransferiblePilotos entidadATransferible(Pilotos pilotos);
    @Mapping(source = "nombre", target = "nombre")
    List<TransferiblePilotos> toDTOList(List<Pilotos> pilotos);
}
