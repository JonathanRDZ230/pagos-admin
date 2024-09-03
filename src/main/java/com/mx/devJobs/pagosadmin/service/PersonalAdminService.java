package com.mx.devJobs.pagosadmin.service;

import com.mx.devJobs.pagosadmin.dto.PersonalAdminDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.PersonalAdmin;
import java.util.List;

public interface PersonalAdminService {

    List<PersonalAdmin> getAllPersonalAdmin();

    Response guardarPersonal(PersonalAdminDTO datos);

    Response deleteById(Long personaId);

    PersonalAdmin obtenerUsuario(String username);

    List<PersonalAdmin> obtenerDatosPersonalAdmin();

    PersonalAdmin getDatosAdmin(String personaId);
}
