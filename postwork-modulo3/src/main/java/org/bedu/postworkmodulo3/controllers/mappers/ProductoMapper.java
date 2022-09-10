package org.bedu.postworkmodulo3.controllers.mappers;

import org.bedu.postworkmodulo3.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto productoModelToProductoEntity(org.bedu.postworkmodulo3.model.Producto ProductoEntity);
    org.bedu.postworkmodulo3.model.Producto productoEntityToProductoModel(Producto productoModel);

}
