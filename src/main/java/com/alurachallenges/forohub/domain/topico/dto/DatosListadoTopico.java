package com.alurachallenges.forohub.domain.topico.dto;

import com.alurachallenges.forohub.domain.topico.Topico;
import com.alurachallenges.forohub.domain.usuario.Usuario;

public record DatosListadoTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 String fecha,
                                 String estatus,
                                 Usuario autor,
                                 String curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getEstatus().toString(), topico.getAutor(), topico.getCurso().toString());
    }



}
