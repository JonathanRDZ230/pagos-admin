package com.mx.devJobs.pagosadmin.repository;

import com.mx.devJobs.pagosadmin.dto.PersonalAdminDTO;
import com.mx.devJobs.pagosadmin.entities.PersonalAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalAdminRepository extends JpaRepository<PersonalAdmin,Long> {

    PersonalAdmin findByUsername(String username);


    @Query(value = "SELECT * FROM CURSOADMIN.PERSONAL_ADMIN A",nativeQuery = true)
    List<PersonalAdmin> obtenerDatosPersonalAdmin();


}
