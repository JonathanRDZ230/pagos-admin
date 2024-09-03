package com.mx.devJobs.pagosadmin.serviceImpl;

import com.mx.devJobs.pagosadmin.dto.InformeEmpleadosDTO;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.InformeEmpleados;
import com.mx.devJobs.pagosadmin.repository.InformeEmpleadosRepository;
import com.mx.devJobs.pagosadmin.service.InformeEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class InformeEmpleadosServiceImpl implements InformeEmpleadosService {

    @Autowired
    private InformeEmpleadosRepository informeEmpleadosRepository;

    @Override
    @Transactional
    public Response registrarNuevoEmpleado(InformeEmpleadosDTO informeDatos) {
        String curp = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])([HM]{1})"
                + "(AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
                + "[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d]{1}\\d{1}$",
                rfc = "^[A-ZÑ&]{3,4}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[A-Z\\d]{3}$" /*nss = "\\d+"*/;
        InformeEmpleados insertDatos = new InformeEmpleados();
        InformeEmpleados empleadoExistente = informeEmpleadosRepository.findByUniqueValues(
                informeDatos.getNombreCompleto(), informeDatos.getRfc(), informeDatos.getCurp(), informeDatos.getNss(),
                informeDatos.getTelefono());
        if (informeDatos.getRfc() == null) {
            return new Response(500, "El RFC no debe estar vacio");
        }
        if (informeDatos.getCurp() == null) {
            return new Response(500, "El CURP no debe estar vacio");
        }
        if (informeDatos.getNss() == null) {
            return new Response(500, "El NSS no debe estar vacio");
        }
        if (empleadoExistente != null) {
            return new Response(400, "El empleado ya esta registrado");
        }

        insertDatos.setNombreCompleto(informeDatos.getNombreCompleto());

        Pattern patternRfc = Pattern.compile(rfc);
        Matcher matcherRfc = patternRfc.matcher(informeDatos.getRfc());
        if (matcherRfc.matches()) {
            insertDatos.setRfc(informeDatos.getRfc());
        } else {
            return new Response(400, "El RFC que intentas ingresar no es valido, revisa de nuevo e intentalo mas tarde...");
        }

        Pattern patternCurp = Pattern.compile(curp);
        Matcher matcherCurp = patternCurp.matcher(informeDatos.getCurp());
        if (matcherCurp.matches()) {
            insertDatos.setCurp(informeDatos.getCurp());
        } else {
            return new Response(400, "La CURP que intentas agregar, no es valida, Verifica de nuevo por favor...");
        }

        insertDatos.setEdad(informeDatos.getEdad());
        insertDatos.setSexo(informeDatos.getSexo());
        insertDatos.setDireccion(informeDatos.getDireccion());

		/*Pattern patternNss = Pattern.compile(nss);
		Matcher matcherNss = patternNss.matcher(datosInforme.getNss().toString());*/
        if (!informeDatos.getNss().toString().matches("\\d+") || informeDatos.getNss() == null) {
            return new Response(400, "El campo NSS debe ser numerico");
        } else if (informeDatos.getNss().toString().length() != 10) {
            return new Response(400, "Su NSS no cuenta con la estructura adecuada");
        } else {
            insertDatos.setNss(informeDatos.getNss());
        }
        insertDatos.setTelefono(informeDatos.getTelefono());
        insertDatos.setActivo(informeDatos.getActivo());

        informeEmpleadosRepository.save(insertDatos);

        return new Response(200, "Empleado registrado correctamente");
    }

    @Override
    @Transactional
    public Response eliminarEmpleado(InformeEmpleadosDTO idEmpleado) {
        Response response = new Response();
        List<InformeEmpleados> listaCompleta = informeEmpleadosRepository.deleteByIdEmpleado(idEmpleado.getIdEmpleado());
        if (listaCompleta.isEmpty()) {
            response.setContent("VACIO");
            response.setCode(500);
            response.setDescripcion("La id del empleado no existe");
        } else {
            for (InformeEmpleados informeEmpleados : listaCompleta) {
                if (informeEmpleados.getActivo() == 0) {
                    response.setCode(200);
                    response.setDescripcion("Empleado eliminado correctamente");
                    informeEmpleadosRepository.deleteById(idEmpleado.getIdEmpleado());
                } else if (informeEmpleados.getActivo() == 1) {
                    response.setContent(informeEmpleados);
                    response.setCode(400);
                    response.setDescripcion("Imposible eliminar Empleado, Sigue Laborando (Activo)...!");
                }
            }
        }
        return response;
    }

    @Override
    @Transactional
    public Response actualizarEmpleado(InformeEmpleadosDTO informeDatos) {
        Response response = new Response();
        List<InformeEmpleados> registro = informeEmpleadosRepository.findByIdEmpleado(informeDatos.getIdEmpleado());
        if (registro.isEmpty()) {
            return new Response(400, "Empleado no encontrado...");
        }

        for (InformeEmpleados informeEmpleados : registro) {
            if (!informeEmpleados.getNombreCompleto().equals(informeDatos.getNombreCompleto())) {
                return new Response(404,
                        "Los datos no coinciden con el ID, por lo tanto, no puedes actualizar un dato con la ID erronea");
            }

            if (informeEmpleados.getActivo() == 1) {
                informeEmpleados.setNombreCompleto(informeDatos.getNombreCompleto());
                informeEmpleados.setRfc(informeDatos.getRfc());
                informeEmpleados.setCurp(informeDatos.getCurp());
                informeEmpleados.setEdad(informeDatos.getEdad());
                informeEmpleados.setSexo(informeDatos.getSexo());
                informeEmpleados.setDireccion(informeDatos.getDireccion());
                informeEmpleados.setNss(informeDatos.getNss());
                informeEmpleados.setTelefono(informeDatos.getTelefono());
                informeEmpleadosRepository.save(informeEmpleados);
                response.setCode(200);
                response.setDescripcion("Se ha podido actualizar correctamente los datos del empleado...");

            } else {
                return new Response(404, "El empleado está dado de baja, no puede actualizar su información");
            }
        }
        return response;
    }

    @Override
    @Transactional
    public List<InformeEmpleados> getInformeEmpleadoBySexoM(InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosRepository.findBySexoM(informeDatos.getSexo());
    }

    @Override
    @Transactional
    public List<InformeEmpleados> getInformeEmpleadoBySexoYEdad(InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosRepository.findBySexoYEdad(informeDatos.getEdad(), informeDatos.getSexo());
    }

    @Override
    @Transactional
    public List<InformeEmpleados> getInformeEmpleadoByRfc(InformeEmpleadosDTO informeDatos) {
        return informeEmpleadosRepository.findByRfc(informeDatos.getRfc());
    }
}
