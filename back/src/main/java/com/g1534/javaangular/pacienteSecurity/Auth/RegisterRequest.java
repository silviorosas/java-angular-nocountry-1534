package com.g1534.javaangular.pacienteSecurity.Auth;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String nombre;
    String apellido;
    String alias;
    String dni;
    LocalDate fechaNacimiento;
    //String role; puedo dar la opcion de registrar el rol
}
