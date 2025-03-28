package br.univille.projetohotelpracachorro.entity.ensalamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Horarios {
    private String horario;

    @NotBlank(message = "matéria é obrigatória")
    private String materia;

    @NotBlank(message = "professor é obrigatório")
    private String professor;
}
