package com.mx.devJobs.pagosadmin.repository;

import com.mx.devJobs.pagosadmin.entities.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AlumnosRepository extends JpaRepository<Alumnos,Long> {

    /** -- ejmeplos que se explicaron en clase -----
     Alumnos findByUsername(String username); //-=> select * from tabla where username = ?;

    List<Alumnos> obtenerTodosAlum(); //-=> select * from tabla;
     **/

    /** Alumnos findByCurso(String curso); //-=> select * from tabla where curso = ?;  **/

/**
 * OTROS EJEMPLO DE CONSUTASA
 */


    /**@Query(value = "select d.id,d.name,d.breed,d.origin from Dog d",nativeQuery = true)*/
    /**@Query(value ="SELECT nombreCompleto, edad, ubicacion, activo from PersonalAdmin",nativeQuery = true)*/
    /**@Query(value = "SELECT * FROM Alumnos")
    List<Alumnos> obtenerTodosAlum();
     */


    /**@Query("SELECT * FROM ALUMNOS")
    public List<Alumnos> listAlumnos();

    @Query("SELECT NOMBRE_ALUMNO, EDAD, FECHA_INSCRIPCION FROM ALUMNOS WHERE ID_ALUMNO = ?")
    public Alumnos Alumno(int id);
*/
}
