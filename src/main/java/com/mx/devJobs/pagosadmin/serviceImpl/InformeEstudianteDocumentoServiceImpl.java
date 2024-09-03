package com.mx.devJobs.pagosadmin.serviceImpl;

import com.mx.devJobs.pagosadmin.entities.InformeEstudianteDocumento;
import com.mx.devJobs.pagosadmin.repository.InformeEstudianteDocumentoRepository;
import com.mx.devJobs.pagosadmin.service.InformeEstudianteDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InformeEstudianteDocumentoServiceImpl implements InformeEstudianteDocumentoService {

    @Autowired
    private InformeEstudianteDocumentoRepository informeEstudianteDocumentoRepository;

    @Override
    public List<InformeEstudianteDocumento> getList() {
        List<InformeEstudianteDocumento> listaInforme = informeEstudianteDocumentoRepository.findAll();
        return listaInforme;
    }

}
