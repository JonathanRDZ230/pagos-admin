package com.mx.devJobs.pagosadmin.service;

import com.mx.devJobs.pagosadmin.dto.InformeEmpleadosDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.InformeEmpleados;

import java.util.List;

public interface InformeEmpleadosService  {

    Response registrarNuevoEmpleado(InformeEmpleadosDTO informeDatos);

    Response eliminarEmpleado(InformeEmpleadosDTO idEmpleado);

    Response actualizarEmpleado(InformeEmpleadosDTO informeDatos);

    List<InformeEmpleados> getInformeEmpleadoBySexoM(InformeEmpleadosDTO informeDatos);

    List<InformeEmpleados> getInformeEmpleadoBySexoYEdad(InformeEmpleadosDTO informeDatos);

    List<InformeEmpleados> getInformeEmpleadoByRfc(InformeEmpleadosDTO informeDatos);
}
