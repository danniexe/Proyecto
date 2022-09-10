package org.bedu.postworkmodulo3.controllers.mappers;

import org.bedu.postworkmodulo3.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.postworkmodulo3.model.Visita VisitaEntity);
    org.bedu.postworkmodulo3.model.Visita visitaEntityToVisitaModel(Visita visitaModel);

}
