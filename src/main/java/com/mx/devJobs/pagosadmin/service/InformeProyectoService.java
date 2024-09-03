package com.mx.devJobs.pagosadmin.service;

import com.mx.devJobs.pagosadmin.dto.InformeProyectoDTO;
import com.mx.devJobs.pagosadmin.dto.Response;

import java.util.List;
import java.util.Map;

public interface InformeProyectoService {

    Response getInformesByIdRead(InformeProyectoDTO datos);

    Response registrarNuevoInforme(InformeProyectoDTO datosInforme);

    Response deleteInformeProyecto(InformeProyectoDTO idInforme);

    Response updateInformeProyecto(InformeProyectoDTO datosInforme);

    List<Map<String, Object>> consultaRegistro(InformeProyectoDTO datosInforme);
}
