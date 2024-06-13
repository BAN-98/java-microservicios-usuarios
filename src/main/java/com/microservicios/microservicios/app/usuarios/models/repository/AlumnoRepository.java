package com.microservicios.microservicios.app.usuarios.models.repository;

import com.microservicios.microservicios.app.usuarios.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
