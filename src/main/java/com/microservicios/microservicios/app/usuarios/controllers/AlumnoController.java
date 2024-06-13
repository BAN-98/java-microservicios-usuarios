package com.microservicios.microservicios.app.usuarios.controllers;

import com.microservicios.microservicios.app.usuarios.models.entity.Alumno;
import com.microservicios.microservicios.app.usuarios.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(o.get());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Alumno alumno) {
        Alumno newAlumno = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAlumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Long id) {
        Optional <Alumno> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoFounded = o.get();
        alumnoFounded.setName(alumnoFounded.getName());
        alumnoFounded.setEmail(alumnoFounded.getEmail());
        alumnoFounded.setPassword(alumnoFounded.getPassword());
        alumnoFounded.setLastName(alumnoFounded.getLastName());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoFounded));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
