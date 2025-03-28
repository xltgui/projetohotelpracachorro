package br.univille.projetohotelpracachorro.service;

import br.univille.projetohotelpracachorro.dto.ReservaDTO;
import br.univille.projetohotelpracachorro.dto.SalaDTO;
import br.univille.projetohotelpracachorro.entity.Reserva;
import br.univille.projetohotelpracachorro.entity.ensalamento.Sala;

import java.util.List;

public interface SalaService {
    List<Sala> getAll();

    Sala save(SalaDTO reserva);

    SalaDTO findById(long id);

    Sala findSalaById(long id);

    void delete(long id);
}
