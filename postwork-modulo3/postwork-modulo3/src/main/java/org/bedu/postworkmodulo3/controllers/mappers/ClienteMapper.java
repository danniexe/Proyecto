package org.bedu.postworkmodulo3.controllers.mappers;

import org.bedu.postworkmodulo3.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente clienteModelToClienteEntity(org.bedu.postworkmodulo3.model.Cliente clienteModel);

    org.bedu.postworkmodulo3.model.Cliente clienteEntityToClienteModel(Cliente cliente);

}
