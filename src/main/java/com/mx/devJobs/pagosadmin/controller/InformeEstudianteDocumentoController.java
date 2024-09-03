package com.mx.devJobs.pagosadmin.controller;

import com.mx.devJobs.pagosadmin.entities.InformeEstudianteDocumento;
import com.mx.devJobs.pagosadmin.service.InformeEstudianteDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/informeEstudianteDocumento")
@CrossOrigin("*")
public class InformeEstudianteDocumentoController {

    @Autowired
    private InformeEstudianteDocumentoService informeEstudianteDocumentoService;

    @GetMapping("/getListInformeEstudianteDocumento")
    List<InformeEstudianteDocumento> getList() {
        return informeEstudianteDocumentoService.getList();
    }
}
