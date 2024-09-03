package com.mx.devJobs.pagosadmin.serviceImpl;

import com.mx.devJobs.pagosadmin.dto.PersonalAdminDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.PersonalAdmin;
import com.mx.devJobs.pagosadmin.repository.PersonalAdminRepository;
import com.mx.devJobs.pagosadmin.service.PersonalAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PersonalAdminSeviceImpl implements PersonalAdminService {

    @Autowired
    private PersonalAdminRepository personalAdminRepository;

    @Override
    public List<PersonalAdmin> getAllPersonalAdmin() {
        return personalAdminRepository.findAll();
    }

    @Override
    public Response guardarPersonal(PersonalAdminDTO datos) {
        PersonalAdmin entity = new PersonalAdmin();
        Response response = new Response();

        try {
            entity.setNombreCompleto(datos.getNombreCompleto());
            entity.setEdad(datos.getEdad());
            entity.setSexo(datos.getSexo());
            entity.setUbicacion(datos.getUbicacion());
            entity.setActivo(datos.getActivo());
            entity.setDireccion(datos.getDireccion());
            entity.setCarrera(datos.getCarrera());
            entity.setFechaRegistro(new Date());
            entity.setUsername(datos.getUsername());

            personalAdminRepository.save(entity);
            response.setCode(200);
            response.setDescripcion("Usuario guardado correctamente");

        }catch(Exception e){
            response.setCode(500);
            response.setDescripcion("Error al guardar el usuario, intentar de nuevo.");
        }
        return response;
    }

    @Override
    public Response deleteById(Long personaId) {
        Response response = new Response();
        System.out.println("ID-->" + personaId);
        try {

            personalAdminRepository.deleteById(personaId);
            response.setCode(200);
            response.setDescripcion("Usuario eliminado correctamente");
        }catch(Exception e){
            response.setCode(500);
            response.setDescripcion("Error al eliminar el usuario.");
        }
        return response;
    }

    @Override
    public PersonalAdmin obtenerUsuario(String username) {
        return personalAdminRepository.findByUsername(username);
    }

    @Override
    public List<PersonalAdmin> obtenerDatosPersonalAdmin() { // este es el mio isaul - JQEURY
        return personalAdminRepository.obtenerDatosPersonalAdmin();
    }


    @Override
    public PersonalAdmin getDatosAdmin(String personaId) {
        //return personalAdminRepository.getDatosByPersonaId(personaId);
        return null;
    }

}
