package br.univille.projetohotelpracachorro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetohotelpracachorro.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
