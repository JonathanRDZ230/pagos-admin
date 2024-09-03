package com.mx.devJobs.pagosadmin.controller;

import com.mx.devJobs.pagosadmin.dto.APIDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.API;
import com.mx.devJobs.pagosadmin.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ConsumirAPI")
@CrossOrigin("*")
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping("/getAPIcompleto")
    public ResponseEntity<List<APIDTO>> getAPI(){
        return new ResponseEntity<>(apiService.getApiRest(), HttpStatus.OK);
    }

    @GetMapping("/getApiFiltrado")
    public ResponseEntity<List<APIDTO>> getApiRestFiltrado() {
        return new ResponseEntity<>(apiService.getApiFiltrado(), HttpStatus.OK);
    }

    @PostMapping("/insertToDataBase")
    public Response insertCountries(@RequestBody APIDTO datosApi) {
        return apiService.registrarPaises(datosApi);
    }

    @PostMapping("/obtenerPaisDeLaBD")
    public List<API> getCountryByCommon(@RequestBody APIDTO datosCountry) {
        return apiService.getCountryByCommon(datosCountry);
    }
}
