package org.bedu.postworkmodulo3.controllers.mappers;

import org.bedu.postworkmodulo3.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    Venta ventaModelToVentaEntity(org.bedu.postworkmodulo3.model.Venta ventaModel);
    org.bedu.postworkmodulo3.model.Venta ventaEntityToVentaModel(Venta ventaEntity);

}
