package com.g1534.javaangular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.g1534.javaangular.pacienteSecurity.RoleEnum;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="paciente", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Paciente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(nullable = false)
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String alias;
    private String dni;
    private LocalDate fechaNacimiento;     
    @Enumerated(EnumType.STRING) 
    RoleEnum roleEnum;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<Consulta> consulta = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(new SimpleGrantedAuthority((roleEnum.name())));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
       return true;
    }


}
