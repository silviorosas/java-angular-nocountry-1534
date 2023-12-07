package com.g1534.javaangular.controller;

import com.g1534.javaangular.dto.DtoPacienteFindById;
import com.g1534.javaangular.dto.DtoPacienteListar;
import com.g1534.javaangular.model.Paciente;
import com.g1534.javaangular.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<DtoPacienteListar>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Paciente paciente = pacienteService.getPacientePorId(id).get();
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/pacienteId/{id}")
    public ResponseEntity<DtoPacienteFindById> getPatientById(@PathVariable Long id) {
     DtoPacienteFindById dto = pacienteService.findPatientById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente createdPaciente = pacienteService.createPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente( @RequestBody Paciente paciente) {
        Paciente updatedPaciente = pacienteService.updatePaciente(paciente);
        if (updatedPaciente != null) {
            return ResponseEntity.ok(updatedPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }
}
