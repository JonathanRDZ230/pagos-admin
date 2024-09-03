package com.mx.devJobs.pagosadmin.controller;

import com.mx.devJobs.pagosadmin.entities.InformeEmpleados;
import com.mx.devJobs.pagosadmin.entities.TipoInforme;
import com.mx.devJobs.pagosadmin.service.TipoInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tipoInforme")
@CrossOrigin("*")
public class TipoInformeController {

    @Autowired
    private TipoInformeService tipoInformeService;

    @GetMapping("/getTipoInforme")
    List<TipoInforme> getTipoInforme() {
        return tipoInformeService.getListTipoInforme();
    }
}
