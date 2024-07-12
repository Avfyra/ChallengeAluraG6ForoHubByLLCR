package com.alurachallenges.forohub.domain.topico;

import com.alurachallenges.forohub.domain.topico.dto.DatosActualizarTopico;
import com.alurachallenges.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table (name = "topicos")
@Entity (name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    @Enumerated(EnumType.STRING)
    private Status estatus;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @Column(nullable = false)
    private boolean activo = true; // Inicializa como activo por defecto

    public Topico(String titulo, String mensaje, Curso curso, Usuario autor) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now().format(formatter);
        this.estatus = Status.SOLUCION_PENDIENTE;
        this.autor = autor;
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.estatus() != null){
            this.estatus = Status.valueOf(datosActualizarTopico.estatus());
        }
        if (datosActualizarTopico.curso() != null){
            this.curso = Curso.valueOf(datosActualizarTopico.curso());
        }
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", curso='" + curso + '\'' +
                ", fecha=" + fecha +
                ", autor=" + autor +
                '}';
    }

}
