package com.mx.devJobs.pagosadmin.serviceImpl;

import com.mx.devJobs.pagosadmin.dto.InformeProyectoDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.BitacoraInformeStatus;
import com.mx.devJobs.pagosadmin.entities.InformeProyecto;
import com.mx.devJobs.pagosadmin.entities.InformeProyectoPrimaryKey;
import com.mx.devJobs.pagosadmin.entities.InformeUsuarioStatus;
import com.mx.devJobs.pagosadmin.repository.BitacoraInformeStatusRepository;
import com.mx.devJobs.pagosadmin.repository.InformeProyectoRepository;
import com.mx.devJobs.pagosadmin.repository.InformeUsuariosStatusRepository;
import com.mx.devJobs.pagosadmin.service.InformeProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class InformeProyectoServiceImpl implements InformeProyectoService {

    @Autowired
    private InformeProyectoRepository informeProyectoRepository;

    @Autowired
    private InformeUsuariosStatusRepository informeUsuariosStatusRepository;

    @Autowired
    private BitacoraInformeStatusRepository bitacoraInformeStatusRepository;

    @Override
    @Transactional
    public Response getInformesByIdRead(InformeProyectoDTO datos) {
        Response response = new Response();
        InformeProyectoPrimaryKey id = new InformeProyectoPrimaryKey();
        id.setIdInforme(datos.getIdInforme());
        id.setIdProyecto(datos.getIdProyecto());
        id.setAnio(datos.getAnio());
        id.setNumeroConvocatoria(datos.getNumeroConvocatoria());
        id.setCveTipoInforme(datos.getCveTipoInforme());
        Optional<InformeProyecto> resultado = informeProyectoRepository.findById(id);
        if(resultado.isPresent()) {
            response.setContent(resultado);
            response.setCode(200);
            response.setDescripcion("Informe Encontrado");
        } else {
            response.setCode(100);
            response.setDescripcion("Informe NO encontrado");
        }
        return response;
    }

    @Override
    @Transactional
    public Response registrarNuevoInforme(InformeProyectoDTO datosInforme) {
        InformeProyectoPrimaryKey id = new InformeProyectoPrimaryKey();
        id.setIdInforme(datosInforme.getIdInforme());
        id.setIdProyecto(datosInforme.getIdProyecto());
        id.setAnio(datosInforme.getAnio());
        id.setNumeroConvocatoria(datosInforme.getNumeroConvocatoria());
        id.setCveTipoInforme(datosInforme.getCveTipoInforme());

        InformeProyecto informeEntity = new InformeProyecto();
        informeEntity.setId(id);
        informeEntity.setUsuario(datosInforme.getUsuario());
        informeEntity.setFechaRegistroInforme(datosInforme.getFechaRegistroInforme());
        informeEntity.setFechaEnvioInforme(datosInforme.getFechaEnvioInforme());
        informeEntity.setCveEstatusInforme(datosInforme.getCveEstatusInforme());
        informeEntity.setCveInstitucion(datosInforme.getCveInstitucion());
        informeEntity.setEsDecimoAnio(datosInforme.getEsDecimoAnio());

        informeProyectoRepository.save(informeEntity);

        return new Response(200, "Informe resgitrado correctamente", informeEntity);
    }

    @Override
    @Transactional
    public Response deleteInformeProyecto(InformeProyectoDTO idInforme) {
//		delete from tabla where id= 1;
        try {
            InformeProyectoPrimaryKey idDelete = new InformeProyectoPrimaryKey();
            idDelete.setAnio(idInforme.getAnio());
            idDelete.setCveTipoInforme(idInforme.getCveTipoInforme());
            idDelete.setIdInforme(idInforme.getIdInforme());
            idDelete.setIdProyecto(idInforme.getIdProyecto());
            idDelete.setNumeroConvocatoria(idInforme.getNumeroConvocatoria());
//		JDBC -> delete from tabla where id_anio= 1 and id:informe = ?
            informeProyectoRepository.deleteById(idDelete);
        } catch (Exception e) {
            return new Response(500, "Ocurrio un error en el server", e.getMessage());
        }
        return new Response(200, "Se elimino el informe");
    }
//PENDIENTE
    @Override
    @Transactional
    public Response updateInformeProyecto(InformeProyectoDTO datosInforme) {
        InformeProyectoPrimaryKey idUpdate = new InformeProyectoPrimaryKey();
        idUpdate.setAnio(datosInforme.getAnio());
        idUpdate.setCveTipoInforme(datosInforme.getCveTipoInforme());
        idUpdate.setIdInforme(datosInforme.getIdInforme());
        idUpdate.setIdProyecto(datosInforme.getIdProyecto());
        idUpdate.setNumeroConvocatoria(datosInforme.getNumeroConvocatoria());

        Optional<InformeProyecto> informeExistente = informeProyectoRepository.findById(idUpdate);
        if (!informeExistente.isPresent()) { return new Response(404, "Informe no encontrado"); }

        InformeProyecto informeEntity = informeExistente.get();

        informeEntity.setUsuario(datosInforme.getUsuario());
        informeEntity.setFechaRegistroInforme(datosInforme.getFechaRegistroInforme());
        informeEntity.setFechaEnvioInforme(datosInforme.getFechaEnvioInforme());
        informeEntity.setCveEstatusInforme(datosInforme.getCveEstatusInforme());
        informeEntity.setCveInstitucion(datosInforme.getCveInstitucion());
        informeEntity.setEsDecimoAnio(datosInforme.getEsDecimoAnio());

        informeProyectoRepository.save(informeEntity);

        return new Response(200, "Se actualizo el informe", informeEntity);
    }

    @Override
    @Transactional
    public List<Map<String, Object>> consultaRegistro(InformeProyectoDTO datosInforme) {
        List<InformeProyecto> listaInforme = informeProyectoRepository.findByAnioTipoInfEsDecimo(
                datosInforme.getAnio(),datosInforme.getCveTipoInforme(),datosInforme.getEsDecimoAnio());
        List<Map<String, Object>> listaFiltrada = new ArrayList<>();
        List<String> listaFiltroConsulta = new ArrayList<>();

        List<InformeUsuarioStatus> listInformeUsuario = new ArrayList<>();
        List<BitacoraInformeStatus> listBitacoraInforme = new ArrayList<>();

        String r, status = "", anio = "", bandera = "", idProyecto = "", folio = "";

        System.out.println("(ANIO)_(ID_PROYECTO)_(NUMERO_CONVOCATORIA)_(CVE_ESTATUS_INFORME)_(ES_DECIMO_ANIO)_(Fecha_Actual)");
        for (InformeProyecto informe : listaInforme) {
            Map<String, Object> mapeo = new HashMap<>();
            mapeo.put("anio", informe.getId().getAnio());
            mapeo.put("idProyecto", informe.getId().getIdProyecto());
            mapeo.put("numeroConvocatoria", informe.getId().getNumeroConvocatoria());
            mapeo.put("cveEstatusInforme", informe.getCveEstatusInforme());
            mapeo.put("esDecimoAnio", informe.getEsDecimoAnio());
            r = informe.getId().getAnio() + "-" + informe.getId().getIdProyecto()
                    + "-" + informe.getId().getNumeroConvocatoria() + "-"
                    + informe.getCveEstatusInforme() + "-" + informe.getEsDecimoAnio() + "-"
                    + new Date();
            System.out.println(r);
            listaFiltroConsulta.add(r);
            listaFiltrada.add(mapeo);

            InformeUsuarioStatus registros = new InformeUsuarioStatus();
            registros.setUsuario(informe.getUsuario());
            registros.setFechaActual(new Date());
            registros.setNumeroProyecto(informe.getId().getIdProyecto());
            status = informe.getCveEstatusInforme().equals(1) ? "En captura" :
                    informe.getCveEstatusInforme().equals(2) ? "Enviados" : null;
            registros.setStatus(status);
            for (String valorR : listaFiltroConsulta) {
                registros.setConsultaInformeUsuario(valorR);
            }
            listInformeUsuario.add(registros);

            BitacoraInformeStatus datosBitacora = new BitacoraInformeStatus();
            datosBitacora.setIdProyecto(informe.getId().getIdProyecto());
            datosBitacora.setUsuario(informe.getUsuario());
            datosBitacora.setFechaActual(new Date());
            datosBitacora.setFechaRegistroInforme(informe.getFechaRegistroInforme());
            datosBitacora.setFechaEnvioInforme(informe.getFechaEnvioInforme());
            bandera = informe.getCveEstatusInforme().equals(1) ? "01_ACTIVO" :
                    informe.getCveEstatusInforme().equals(2) ? "02_EN_PROCESO_DE_VALIDACION" : null;
            datosBitacora.setBanderaTransaccion(bandera);
            anio = String.valueOf(informe.getId().getAnio()).substring(2);
            idProyecto = String.valueOf(informe.getId().getIdProyecto());
            folio = anio + idProyecto;
            datosBitacora.setFolioProyecto(Integer.valueOf(folio));
            listBitacoraInforme.add(datosBitacora);
        }
        informeUsuariosStatusRepository.saveAll(listInformeUsuario);
        bitacoraInformeStatusRepository.saveAll(listBitacoraInforme);

        System.out.println("Si se registro");

        return listaFiltrada;
    }

}
