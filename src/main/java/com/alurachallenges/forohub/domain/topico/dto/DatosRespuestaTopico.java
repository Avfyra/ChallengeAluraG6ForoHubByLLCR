package com.alurachallenges.forohub.domain.topico.dto;

import com.alurachallenges.forohub.domain.topico.Topico;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String fecha,
        String curso,
        String nombreAutor
) {

    public DatosRespuestaTopico(Topico topico, String login) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getCurso().toString(),
                login
        );
    }
}