package com.mx.devJobs.pagosadmin.serviceImpl;

import com.mx.devJobs.pagosadmin.dto.AlumnoDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.Alumnos;
import com.mx.devJobs.pagosadmin.repository.AlumnosRepository;
import com.mx.devJobs.pagosadmin.service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class AlumnosSeviceImpl implements AlumnosService {

    @Autowired
    private AlumnosRepository alumnosRepository;

    /**
     * Consulta alumnos
     * @return
     */
    @Override
    public List<Alumnos> getAllStudent() {
        return alumnosRepository.findAll(); // => seelct * from tabla;
    }

    /**
     * add new alumno
     * @param datos
     * @return
     */
    @Override
    @Transactional
    public Response guardarAlumno(AlumnoDTO datos) {
        Alumnos entity = new Alumnos();
        Response response = new Response();

        try {
            entity.setNombreAlumno(datos.getNombreAlumno());
            entity.setEdad(datos.getEdad());
            entity.setFechaInscripcion(new Date());
            entity.setCurso(datos.getCurso());
            entity.setMaestro(datos.getMaestro());

            alumnosRepository.save(entity);
            response.setCode(200);
            response.setDescripcion("Usuario guardado correctamente");

        }catch(Exception e){
            response.setCode(500);
            response.setDescripcion("Error al guardar el usuario, intentar de nuevo.");
        }
        return response;
    }


    /**
     * Eliminar por ide
     * @param usuarioId
     */
    @Override
    @Transactional
    public Response deleteById(Long usuarioId) {
        Response response = new Response();
        try {
            alumnosRepository.deleteById(usuarioId);
            response.setCode(200);
            response.setDescripcion("Usuario eliminado correctamente");
        }catch(Exception e){
            response.setCode(500);
            response.setDescripcion("Error al eliminar el usuario.");
        }
        return response;
    }

    /*
    @Override
    @Transactional
    public Response actualizarAlumno(AlumnoDTO datos) {
        Alumnos entity = new Alumnos();
        Response response = new Response();

        try {
            entity.setId(datos.getId);
            entity.setNombreAlumno(datos.getNombreAlumno());
            entity.setEdad(datos.getEdad());
            entity.setFechaInscripcion(new Date());
            entity.setCurso(datos.getCurso());
            entity.setMaestro(datos.getMaestro());

            alumnosRepository.save(entity);
            response.setCode(200);
            response.setDescripcion("Usuario actualizar correctamente");

        }catch(Exception e){
            response.setCode(500);
            response.setDescripcion("Error al guardar el usuario, intentar de nuevo.");
        }
        return response;
    }
     */

    /**
     * Consulta por usuario
     * @param username
     * @return
     */
    @Override
    public Alumnos obtenerUsuario(String username) {
        //return alumnosRepository.findByUsername(username); // select * from tabla where username = ?
        return null;
    }

    @Override
    public List<Alumnos> obtenerTodosAlum() {
        //return alumnosRepository.obtenerTodosAlum();
        return null;
    }
}
