package br.univille.projetohotelpracachorro.service;

import java.util.List;

import br.univille.projetohotelpracachorro.dto.ReservaDTO;
import br.univille.projetohotelpracachorro.entity.Reserva;

public interface ReservaService {
    List<Reserva> getAll();

    Reserva save(ReservaDTO reserva);
    
    ReservaDTO findById(long id);

    Reserva findReservaById(long id);

    void delete(long id);

}
