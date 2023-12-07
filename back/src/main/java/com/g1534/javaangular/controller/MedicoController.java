package com.g1534.javaangular.controller;


import com.g1534.javaangular.model.Consulta;
import com.g1534.javaangular.model.Medico;
import com.g1534.javaangular.service.ConsultaService;
import com.g1534.javaangular.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping
    public List<Medico> getAllConsultas() {
        return service.obtenerTodosLosMedicos();
    }

    @GetMapping("/{id}")
    public Optional<Medico> getConsultaById(@PathVariable Long id) {
        return service.obtenerMedicoPorId(id);
    }

    @PostMapping
    public Medico addConsulta(@RequestBody Medico medico) {
        return service.crearMedico(medico);
    }

    @PutMapping("/{id}")
    public Medico updateConsulta(@RequestBody Medico medico) {
        return service.actualizarMedico(medico);
    }

    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable Long id) {
        service.eliminarMedico(id);
    }
}
