package com.mx.devJobs.pagosadmin.controller;

import com.mx.devJobs.pagosadmin.dto.PersonalAdminDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.PersonalAdmin;
import com.mx.devJobs.pagosadmin.service.PersonalAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personaAdmin")
@CrossOrigin("*") /** Para poder aceptar intercambio de recursos mediante http client, peticion GET, POST, ETC...  */
public class PersonalAdminController {

    @Autowired
    private PersonalAdminService personalAdminService;

    /**
     * Obtener todos los alumnos
     * @return
     */
    @GetMapping("/getAllPersona")
    public List<PersonalAdmin> getAllPersonal(){
        return personalAdminService.getAllPersonalAdmin();
    }

    /**
     * Obtener2 todos los alumnos2
     * @return
     */
    @GetMapping("/obtenDatos")
    public List<PersonalAdmin> obtenerDatosPersonalAdmin(){
        return personalAdminService.obtenerDatosPersonalAdmin();
    }

    /**
     * Obtener3 todos los alumnos3
     * @return
     */
    @GetMapping("/{personaId}")
    public PersonalAdmin getDatosPerso(@PathVariable("personaId") String personaId) {
        return personalAdminService.getDatosAdmin(personaId);
    }

    /**
     * Agregar nuevo usuario
     * @param datos
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addPersonal")  //addNewUserResp
    public Response guardarUsuario(@RequestBody PersonalAdminDTO datos) throws Exception{
        try{
            return personalAdminService.guardarPersonal(datos);
        } catch (Exception e){

            return new Response(500,"Error Interno del Servidor");
        }
    }

    /**
     * eliminar por IDE
     * @param -p-er-so-na-Id
     */
    @DeleteMapping("/{personaId}")
    public Response eliminarUsuario(@RequestBody PersonalAdminDTO id) throws Exception{
        System.out.println("ID_CONTROL-->" + id.getId_personal());
        try {
            return personalAdminService.deleteById(id.getId_personal());
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
    public PersonalAdmin obtenerUsuario(@PathVariable("username") String username) {
        return personalAdminService.obtenerUsuario(username);
    }

    /**

     {
     "nombreCompleto": "Juan Gorge Mil",
     "edad": "52",
     "sexo" : "1",
     "ubicacion": "zacatecas",
     "activo": "0",
     "direccion": "Col. Benito 121",
     "carrera": "Albañil",
     "username": "yp34o"
     }

     */

}
