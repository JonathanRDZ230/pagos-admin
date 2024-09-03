package com.mx.devJobs.pagosadmin.serviceImpl;

import com.mx.devJobs.pagosadmin.entities.TipoInforme;
import com.mx.devJobs.pagosadmin.repository.TipoInformeRepository;
import com.mx.devJobs.pagosadmin.service.TipoInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TipoInformeServiceImpl implements TipoInformeService {

    @Autowired
    private TipoInformeRepository tipoInformeRepository;

    @Override
    public List<TipoInforme> getListTipoInforme() {
        List<TipoInforme> listaTipoInforme = tipoInformeRepository.findAll();
        return listaTipoInforme;
    }
}
