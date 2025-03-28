package br.univille.projetohotelpracachorro.dto;

import br.univille.projetohotelpracachorro.entity.ensalamento.Horarios;
import br.univille.projetohotelpracachorro.entity.ensalamento.Sala;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;
@Data
public class SalaDTO {
    private String nomeSala;
    private Sala sala;
    private List<Horarios> horarios;

    private Long id;

}
