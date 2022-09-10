package org.bedu.postworkmodulo3.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bedu.postworkmodulo3.controllers.mappers.EtapaMapper;
import org.bedu.postworkmodulo3.model.Etapa;
import org.bedu.postworkmodulo3.persistence.EtapaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtapaService {

    private final EtapaRepository repository;
    private final EtapaMapper mapper;

    public Etapa guardaEtapa(Etapa etapa) {
        return mapper.etapaEntitytoEtapaModelo(
                repository.save(mapper.etapaModelotoEtapaEntity(etapa))
        );
    }

    public List<Etapa> obtenEtapas(){
        return repository.findAll().stream().map(etapa -> mapper.etapaEntitytoEtapaModelo(etapa)).collect(Collectors.toList());
    }

    public Optional<Etapa> obtenEtapa(long etapaId) {
        return repository.findById(etapaId)
                .map(etapa -> Optional.of(mapper.etapaEntitytoEtapaModelo(etapa)))
                .orElse(Optional.empty());
    }

    public void eliminaEtapa(long idetapa){
        repository.deleteById(idetapa);
    }

    public Etapa actualizaEtapa(Etapa etapa){
        return mapper.etapaEntitytoEtapaModelo(
                repository.save(mapper.etapaModelotoEtapaEntity(etapa))
        );
    }

    public long cuenteEtapa(){
        return repository.count();
    }
}
