package com.g1534.javaangular.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Consulta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String descripcion;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
        @JoinColumn(name = "paciente_id",nullable = false)
        private Paciente paciente;


        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
        @JoinColumn(name = "medico_id", nullable = false)
        private Medico medico;
}
