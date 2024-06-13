package com.microservicios.microservicios.app.usuarios.services;

import com.microservicios.microservicios.app.usuarios.models.entity.Alumno;

import java.util.Optional;

public interface AlumnoService {
    public Iterable<Alumno> findAll();
    public Optional<Alumno> findById(Long id);
    public Alumno save(Alumno alumno);
    public void delete(Long id);
}
