package com.mx.devJobs.pagosadmin.service;

import com.mx.devJobs.pagosadmin.dto.APIDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.API;

import java.util.List;

public interface APIService {

    List<APIDTO> getApiRest();

    List<APIDTO> getApiFiltrado();

    Response registrarPaises(APIDTO datosApi);

    List<API> getCountryByCommon(APIDTO datosCountry);
}
