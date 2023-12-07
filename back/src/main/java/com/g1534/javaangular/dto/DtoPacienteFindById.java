package com.g1534.javaangular.dto;

import com.g1534.javaangular.model.Paciente;

public record DtoPacienteFindById(Long id,String nombre,String apellido) {
     public DtoPacienteFindById(Paciente paciente){
       this(paciente.getId(),paciente.getNombre(), paciente.getApellido());
    }
    
}
