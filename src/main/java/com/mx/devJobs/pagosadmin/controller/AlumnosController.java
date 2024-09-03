package com.mx.devJobs.pagosadmin.controller;

import com.mx.devJobs.pagosadmin.dto.AlumnoDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.Alumnos;
import com.mx.devJobs.pagosadmin.service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indicarle que trabajamos con servicios de tipo REST
@RequestMapping("/alumnos")
@CrossOrigin("*") /** Para poder aceptar intercambio de recursos mediante http client, peticion GET, POST, ETC...  */
public class AlumnosController {

    @Autowired
    private AlumnosService alumnosService;

    /**
     * Obtener todos los alumnos
     * @return
     */
    @GetMapping("/getAllAlumnos")
    public List<Alumnos> getAllStudent(){
        return alumnosService.getAllStudent();
    }

    /**
     * Agregar nuevo usuario -> localhots:8080/alumnos/
     * @param datos
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/")  //addNewUserResp
    public Response guardarUsuario(@RequestBody AlumnoDTO datos) throws Exception{
        try{
            return alumnosService.guardarAlumno(datos);
        } catch (Exception e){

            return new Response(500,"Error Interno del Servidor");
        }
    }

    /**
     * eliminar por IDE -> localhots:8080/alumnos/50
     * @param usuarioId
     */
    @DeleteMapping("/{usuarioId}")
    public Response eliminarUsuario(Long usuarioId) {
        try {
            return alumnosService.deleteById(usuarioId);
        } catch (Exception e) {
            //Logger.info("Error en (UsuarioController.Clas) -> guardarUsuario" + e.getMessage());
            return new Response(500, "Error al eliminar el alumno");
        }
    }


    /**
     * Get user - username
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public Alumnos obtenerUsuario(@PathVariable("username") String username) {
        return alumnosService.obtenerUsuario(username);
    }

    @GetMapping("/obtenerTodosAlum")
    public List<Alumnos> obtenerTodosAlum(){
        return alumnosService.obtenerTodosAlum();
    }


/**

1.- Ejercicio Lunes fase: 01
          jueves -> fase: 02

2.- Hacer una migracion Spring Framework -> Spring boot
 (Sobre el proyecto que les pase, la misma base de datos, las mismas entidades, ->> LA MISMA FUNCIONALIDAD)
----> Avances: Martes
----> Entrega el viernes --> FUNCIONADO

Pero el avance NO SE SUBE A GIT, PRIMERO VALIDAMOS EN SU LOCAL

 */

}
