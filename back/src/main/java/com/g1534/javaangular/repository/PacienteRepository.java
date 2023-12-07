package com.g1534.javaangular.repository;

import com.g1534.javaangular.model.Paciente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByUsername(String username);

    boolean  existsByUsername(String username);
}
