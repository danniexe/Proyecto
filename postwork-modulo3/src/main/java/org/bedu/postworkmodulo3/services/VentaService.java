package org.bedu.postworkmodulo3.services;

import lombok.AllArgsConstructor;
import org.bedu.postworkmodulo3.controllers.mappers.VentaMapper;
import org.bedu.postworkmodulo3.model.Venta;
import org.bedu.postworkmodulo3.persistence.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VentaService {

    private final VentaRepository repository;
    private final VentaMapper mapper;

    public Venta guardaVenta(Venta venta) {
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(venta))
        );
    }

    public List<Venta> obtenVentas(){
        return repository.findAll().stream().map(venta -> mapper.ventaEntityToVentaModel(venta)).collect(Collectors.toList());
    }

    public Optional<Venta> obtenVenta(long idVenta) {
        return repository.findById(idVenta)
                .map(venta -> Optional.of(mapper.ventaEntityToVentaModel(venta)))
                .orElse(Optional.empty());
    }

    public void eliminaVenta(long idventa){
        repository.deleteById(idventa);
    }

    public Venta actualizaVenta(Venta venta){
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(venta))
        );
    }

    public long cuenteVentas(){
        return repository.count();
    }

}
