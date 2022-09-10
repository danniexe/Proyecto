package org.bedu.postworkmodulo3.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bedu.postworkmodulo3.controllers.mappers.ClienteMapper;
import org.bedu.postworkmodulo3.controllers.mappers.VisitaMapper;
import org.bedu.postworkmodulo3.model.Cliente;
import org.bedu.postworkmodulo3.model.Venta;
import org.bedu.postworkmodulo3.model.Visita;
import org.bedu.postworkmodulo3.persistence.ClienteRepository;
import org.bedu.postworkmodulo3.persistence.VisitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitaService {

    private final VisitaRepository repository;
    private final VisitaMapper mapper;

    public Visita guardaVisita(Visita visita) {
        return mapper.visitaEntityToVisitaModel(
                repository.save(mapper.visitaModelToVisitaEntity(visita))
        );
    }

    public List<Visita> obtenVisitas(){
        return repository.findAll().stream().map(visita -> mapper.visitaEntityToVisitaModel(visita)).collect(Collectors.toList());
    }

    public Optional<Visita> obtenVisita(long idVisita) {
        return repository.findById(idVisita)
                .map(visita -> Optional.of(mapper.visitaEntityToVisitaModel(visita)))
                .orElse(Optional.empty());
    }

    public void eliminaVisita(long idvisita){
        repository.deleteById(idvisita);
    }

    public Visita actualizaVisita(Visita visita){
        return mapper.visitaEntityToVisitaModel(
                repository.save(mapper.visitaModelToVisitaEntity(visita))
        );
    }

    public long cuenteVisita(){
        return repository.count();
    }




}
