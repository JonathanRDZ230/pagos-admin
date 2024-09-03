package com.mx.devJobs.pagosadmin.repository;

import com.mx.devJobs.pagosadmin.entities.API;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface APIRepository extends JpaRepository<API, Long> {

    @Query(value = "SELECT * FROM REST_COUNTRIES_API WHERE COMMON = :common", nativeQuery = true)
    List<API> getFindCountry(@Param("common") String common);

    API findByCommon(String common);

}
