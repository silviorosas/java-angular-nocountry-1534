package com.g1534.javaangular.pacienteSecurity;

import java.time.LocalDate;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequest {
     int id;
     String username;
     String nombre;
     String apellido;
     String alias;
     String dni;
     LocalDate fechaNacimiento;
    
}
