package com.mx.devJobs.pagosadmin.repository;

import com.mx.devJobs.pagosadmin.entities.InformeProyecto;
import com.mx.devJobs.pagosadmin.entities.InformeProyectoPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InformeProyectoRepository extends JpaRepository<InformeProyecto, InformeProyectoPrimaryKey> {

    //InformeProyecto findByIdRead(InformeProyectoDTO datos);

    @Query(value = "SELECT * FROM INFORME_PROYECTO WHERE ANIO = :anio AND CVE_TIPO_INFORME = :tipoInforme AND ES_DECIMO_ANIO = :esDecimoAnio", nativeQuery = true)
    List<InformeProyecto> findByAnioTipoInfEsDecimo(@Param("anio") short anio, @Param("tipoInforme") Integer tipoInforme, @Param("esDecimoAnio") Integer esDecimoAnio);
}
