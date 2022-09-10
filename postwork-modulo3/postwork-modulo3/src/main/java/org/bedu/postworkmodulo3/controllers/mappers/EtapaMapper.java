package org.bedu.postworkmodulo3.controllers.mappers;

import org.bedu.postworkmodulo3.persistence.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {
    Etapa etapaModelotoEtapaEntity(org.bedu.postworkmodulo3.model.Etapa etapaEntity);
    org.bedu.postworkmodulo3.model.Etapa etapaEntitytoEtapaModelo(Etapa etapa);
}
