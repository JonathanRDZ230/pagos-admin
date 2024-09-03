package com.mx.devJobs.pagosadmin.controller;

import com.mx.devJobs.pagosadmin.dto.InformeEmpleadosDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.InformeEmpleados;
import com.mx.devJobs.pagosadmin.service.InformeEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/informeEmpleados")
@CrossOrigin("*")
public class InformeEmpleadosController {

    @Autowired
    private InformeEmpleadosService informeEmpleadosService;

    @PostMapping("/insertarNuevoEmpleado")
    Response insertarNuevoEmpleado(@RequestBody InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosService.registrarNuevoEmpleado(informeDatos);
    }

    @DeleteMapping("/eliminarEmpleado")
    Response elimnarEmpleado(@RequestBody InformeEmpleadosDTO idEmpleado) {
        return informeEmpleadosService.eliminarEmpleado(idEmpleado);
    }

    @PutMapping("/actualizarEmpleado")
    Response actualizarEmpleado(@RequestBody InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosService.actualizarEmpleado(informeDatos);
    }

    @PostMapping("/getInformeEmpleadoBySexoM")
    List<InformeEmpleados> getInformeEmpleadoBySexoM(@RequestBody InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosService.getInformeEmpleadoBySexoM(informeDatos);
    }

    @PostMapping("/getInformeEmpleadoBySexoYEdad")
    List<InformeEmpleados> getInformeEmpleadoBySexoYEdad(@RequestBody InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosService.getInformeEmpleadoBySexoYEdad(informeDatos);
    }

    @PostMapping("/getInformeEmpleadoByRfc")
    List<InformeEmpleados> getInformeEmpleadoByRfc(@RequestBody InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosService.getInformeEmpleadoByRfc(informeDatos);
    }

}
