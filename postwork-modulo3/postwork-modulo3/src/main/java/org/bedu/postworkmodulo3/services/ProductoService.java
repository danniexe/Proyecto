package org.bedu.postworkmodulo3.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bedu.postworkmodulo3.controllers.mappers.ClienteMapper;
import org.bedu.postworkmodulo3.controllers.mappers.ProductoMapper;
import org.bedu.postworkmodulo3.model.Cliente;
import org.bedu.postworkmodulo3.model.Producto;
import org.bedu.postworkmodulo3.persistence.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;
    private final ProductoMapper mapper;

    public Producto guardaProducto(Producto producto) {
        return mapper.productoEntityToProductoModel(
                repository.save(mapper.productoModelToProductoEntity(producto))
        );
    }

    public List<Producto> obtenProductos(){
        return repository.findAll().stream().map(producto  -> mapper.productoEntityToProductoModel(producto)).collect(Collectors.toList());
    }

    public Optional<Producto> obtenProducto(long idProducto) {
        return repository.findById(idProducto)
                .map(producto -> Optional.of(mapper.productoEntityToProductoModel(producto)))
                .orElse(Optional.empty());
    }

    public void eliminaProducto(long idcliente){
        repository.deleteById(idcliente);
    }

    public Producto actualizaProducto(Producto  producto){
        return mapper.productoEntityToProductoModel(
                repository.save(mapper.productoModelToProductoEntity(producto))
        );
    }

    public long cuenteProducto(){
        return repository.count();
    }

}
