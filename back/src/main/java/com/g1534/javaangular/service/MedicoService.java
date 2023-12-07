package com.g1534.javaangular.service;

import com.g1534.javaangular.model.Medico;
import com.g1534.javaangular.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> obtenerTodosLosMedicos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> obtenerMedicoPorId(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico crearMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void eliminarMedico(Long id) {
        medicoRepository.deleteById(id);
    }

    public Medico actualizarMedico(Medico medicoActualizado) {
        return medicoRepository.save(medicoActualizado);
    }
}

