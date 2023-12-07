package com.g1534.javaangular.pacienteSecurity.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.g1534.javaangular.model.Paciente;
import com.g1534.javaangular.pacienteSecurity.RoleEnum;
import com.g1534.javaangular.pacienteSecurity.ExceptionHandler.UsernameExistsException;
import com.g1534.javaangular.pacienteSecurity.Jwt.JwtService;
import com.g1534.javaangular.repository.PacienteRepository;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PacienteRepository pacienteRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=pacienteRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
       if (pacienteRepository.existsByUsername(request.getUsername())) {
            throw new UsernameExistsException("El nombre de usuario ya está en uso");
        }
        Paciente user = Paciente.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .nombre(request.getNombre())
            .apellido(request.apellido)
            .alias(request.getAlias())
            .dni(request.getDni())
            .fechaNacimiento(request.getFechaNacimiento())//.role(Role.valueOf(request.role)) puedo dar opcion a registrar el rol
            .roleEnum(RoleEnum.USER).build();
            pacienteRepository.save(user);      

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

}
