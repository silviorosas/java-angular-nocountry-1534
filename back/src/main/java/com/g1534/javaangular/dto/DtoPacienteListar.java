package com.g1534.javaangular.dto;

import com.g1534.javaangular.model.Paciente;

public record DtoPacienteListar(String nombre,String apellido,String alias) {

    public DtoPacienteListar(Paciente paciente){
       this(paciente.getNombre(), paciente.getApellido(), paciente.getAlias());
    }
}
