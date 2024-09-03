package com.mx.devJobs.pagosadmin.controller;

import com.mx.devJobs.pagosadmin.dto.InformeProyectoDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.service.InformeProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/informeProyecto")
@CrossOrigin("*")
public class InformeProyectoController {

    @Autowired
    private InformeProyectoService informeProyectoService;

    @PostMapping("/getUsuariosByIdRead")
    Response getUsuariosByIdRead(@RequestBody InformeProyectoDTO datos) {
        return informeProyectoService.getInformesByIdRead(datos);
    }

    @PostMapping("/nuevoFormularioInformeProyecto")
    Response insertInformeProyecto(@RequestBody InformeProyectoDTO datosInforme) {
        return informeProyectoService.registrarNuevoInforme(datosInforme);
    }

    @DeleteMapping("/eliminarInformeProyecto")
    Response eliminarInformeProyecto(@RequestBody InformeProyectoDTO idInforme) {
        return informeProyectoService.deleteInformeProyecto(idInforme);
    }

    @PutMapping("/actualizarInformeProyecto")
    Response actualizarInformeProyecto(@RequestBody InformeProyectoDTO datosInforme) {
        return informeProyectoService.updateInformeProyecto(datosInforme);
    }

    @PostMapping("/consultaDatos")
    List<Map<String,Object>> consultaDatos(@RequestBody InformeProyectoDTO datosInforme) {
       return informeProyectoService.consultaRegistro(datosInforme);
    }
}
