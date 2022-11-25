package br.univille.projetohotelpracachorro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import br.univille.projetohotelpracachorro.dto.ReservaDTO;
import br.univille.projetohotelpracachorro.entity.Reserva;
import br.univille.projetohotelpracachorro.repository.ReservaRepository;
import br.univille.projetohotelpracachorro.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository repositorio;

    @Override
    public List<Reserva> getAll() {
        
        return repositorio.findAll();
    }

    @Override
    public Reserva save(ReservaDTO reserva) {
        Reserva novaReserva = findReservaById(reserva.getId());
        if(novaReserva == null){
            novaReserva = new Reserva();
        }
        novaReserva.setListaAtendentes(reserva.getListaAtendentes());
        novaReserva.setCachorro(reserva.getCachorro());
        novaReserva.setListaClientes(reserva.getListaClientes());
        novaReserva.setDataEntrada(reserva.getDataEntrada());
        novaReserva.setId(reserva.getId());
        novaReserva.setListaServicos(reserva.getListaServicos());

        return repositorio.save(novaReserva);
    }

    @Override
    public ReservaDTO findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            var reservaAntiga = resultado.get();
            ReservaDTO reserva = new ReservaDTO();
            reserva.setListaAtendentes(reservaAntiga.getListaAtendentes());
            reserva.setCachorro(reservaAntiga.getCachorro());
            reserva.setListaClientes(reservaAntiga.getListaClientes());
            reserva.setDataEntrada(reservaAntiga.getDataEntrada());
            reserva.setId(reservaAntiga.getId());
            reserva.setListaServicos(reservaAntiga.getListaServicos());
            return reserva;
        }    
        return new ReservaDTO();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Reserva findReservaById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Reserva();
    }

}
