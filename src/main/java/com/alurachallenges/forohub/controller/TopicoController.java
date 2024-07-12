package com.alurachallenges.forohub.controller;

import com.alurachallenges.forohub.domain.topico.*;
import com.alurachallenges.forohub.domain.topico.dto.DatosActualizarTopico;
import com.alurachallenges.forohub.domain.topico.dto.DatosRegistroTopico;
import com.alurachallenges.forohub.domain.topico.dto.DatosRespuestaTopico;
import com.alurachallenges.forohub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
            UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuarioActual = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idUsuarioActual = usuarioActual.getId();

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje(), datosRegistroTopico.curso(), usuarioActual));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico, usuarioActual.getLogin());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<List<DatosRespuestaTopico>> listarTopicos() {
        List<Topico> topicosActivos = topicoRepository.findAllByActivoIsTrue();
        List<DatosRespuestaTopico> respuesta = new ArrayList<>(); // Crea una lista vacía

        for (Topico topico : topicosActivos) { // Recorre la lista de tópicos
            respuesta.add(new DatosRespuestaTopico(topico, topico.getAutor().getLogin())); // Agrega a la lista
        }

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico, topico.getAutor().getLogin());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico, topico.getAutor().getLogin()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        try {
            Optional<Topico> topicoOptional = topicoRepository.findById(id);
            if (topicoOptional.isPresent()) {
                Topico topico = topicoOptional.get();
                topico.setActivo(false); // Cambia el estado a inactivo
                topicoRepository.save(topico); // Guarda el cambio
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el tópico");
        }
    }
}