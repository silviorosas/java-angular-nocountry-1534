package com.g1534.javaangular.service;

import com.g1534.javaangular.dto.DtoPacienteFindById;
import com.g1534.javaangular.dto.DtoPacienteListar;
import com.g1534.javaangular.model.Paciente;
import com.g1534.javaangular.repository.PacienteRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

   public List<DtoPacienteListar> getAllPacientes() {
        return pacienteRepository.findAll().stream().map(DtoPacienteListar::new).toList();
    }

    public Optional<Paciente> getPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public DtoPacienteFindById findPatientById(Long id) {
        Paciente patient = pacienteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("No existe paciente con  id: " + id));

        return new DtoPacienteFindById(patient.getId(), patient.getNombre(), patient.getApellido());
    }
    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente updatePaciente(Paciente pacienteActualizado) {
        return pacienteRepository.save(pacienteActualizado);
    }
}
