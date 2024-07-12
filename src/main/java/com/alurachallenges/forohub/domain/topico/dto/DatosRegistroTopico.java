package com.alurachallenges.forohub.domain.topico.dto;

import com.alurachallenges.forohub.domain.topico.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Curso curso) {


}
