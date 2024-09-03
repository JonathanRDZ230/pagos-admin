package com.mx.devJobs.pagosadmin.service;

import com.mx.devJobs.pagosadmin.dto.AlumnoDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.Alumnos;
import java.util.List;

public interface AlumnosService {

    List<Alumnos> getAllStudent();

    Response guardarAlumno(AlumnoDTO datos);

    Response deleteById(Long usuarioId);

    Alumnos obtenerUsuario(String username);

    List<Alumnos> obtenerTodosAlum();
}
