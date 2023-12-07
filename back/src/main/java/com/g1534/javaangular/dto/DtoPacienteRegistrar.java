package com.g1534.javaangular.dto;

import java.time.LocalDate;

public record DtoPacienteRegistrar(
     String username,
     String password,
     String nombre,
     String apellido,
     String alias,
     String dni,
     LocalDate fechaNacimiento) {

   
}
