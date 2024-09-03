package com.mx.devJobs.pagosadmin.repository;

import com.mx.devJobs.pagosadmin.entities.InformeEmpleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InformeEmpleadosRepository extends JpaRepository<InformeEmpleados, Long> {

    @Query(value = "SELECT * FROM INFORME_EMPLEADOS WHERE NOMBRE_COMPLETO = :nombreCompleto AND RFC = :rfc AND CURP = :curp " +
            "AND NSS = :nss AND TELEFONO = :telefono", nativeQuery = true)
    InformeEmpleados findByUniqueValues(@Param("nombreCompleto") String nombreCompleto, @Param("rfc") String rfc,
                                             @Param("curp") String curp, @Param("nss") Long nss, @Param("telefono") Long telefono);

    @Query(value = "SELECT * FROM INFORME_EMPLEADOS WHERE ID_EMPLEADO = :idEmpleado", nativeQuery = true)
    List<InformeEmpleados> deleteByIdEmpleado(@Param("idEmpleado") Long idEmpleado);
    List<InformeEmpleados> findByIdEmpleado(@Param("idEmpleado") Long idEmpleado);

    @Query(value = "SELECT * FROM INFORME_EMPLEADOS WHERE SEXO = :sexo", nativeQuery = true)
    List<InformeEmpleados> findBySexoM(@Param("sexo") char sexo);

    @Query(value = "SELECT * FROM INFORME_EMPLEADOS WHERE EDAD = :edad AND SEXO = :sexo", nativeQuery = true)
    List<InformeEmpleados> findBySexoYEdad(@Param("edad") Integer edad, @Param("sexo") char sexo);

    @Query(value = "SELECT * FROM INFORME_EMPLEADOS WHERE RFC = :rfc", nativeQuery = true)
    List<InformeEmpleados> findByRfc(@Param("rfc") String rfc);
}
