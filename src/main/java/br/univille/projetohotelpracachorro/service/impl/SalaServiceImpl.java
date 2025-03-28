package br.univille.projetohotelpracachorro.service.impl;

import br.univille.projetohotelpracachorro.dto.SalaDTO;
import br.univille.projetohotelpracachorro.entity.ensalamento.Sala;
import br.univille.projetohotelpracachorro.repository.SalaRepository;
import br.univille.projetohotelpracachorro.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> getAll() {
        return salaRepository.findAll();
    }

    @Override
    public Sala save(SalaDTO salaDTO) {
        Sala novaSala = findSalaById(salaDTO.getId());

        if(novaSala == null){
            novaSala = new Sala();
        }
        novaSala.setNomeSala(salaDTO.getNomeSala());
        novaSala.setHorarios(salaDTO.getHorarios());
        novaSala.setId(salaDTO.getId());
        return salaRepository.save(novaSala);
    }

    @Override
    public SalaDTO findById(long id) {
        var resultado = salaRepository.findById(id);
        if(resultado.isPresent()) {
            var salaAntiga = resultado.get();
            SalaDTO salaDTO = new SalaDTO();
            salaDTO.setNomeSala(salaAntiga.getNomeSala());
            salaDTO.setHorarios(salaAntiga.getHorarios());
            salaDTO.setId(resultado.get().getId());

            return salaDTO;
        }
        return new SalaDTO();
    }

    @Override
    public void delete(long id) {
        salaRepository.deleteById(id);
    }

    @Override
    public Sala findSalaById(long id) {
        var resultado = salaRepository.findById(id);
        if(resultado.isPresent()) {
            return resultado.get();
        }
        return new Sala();
    }
}
