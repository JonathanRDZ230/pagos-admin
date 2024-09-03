package com.mx.devJobs.pagosadmin.serviceImpl;

import com.mx.devJobs.pagosadmin.dto.APIDTO;
import com.mx.devJobs.pagosadmin.dto.Currency;
import com.mx.devJobs.pagosadmin.dto.NativeName;
import com.mx.devJobs.pagosadmin.dto.Response;
import com.mx.devJobs.pagosadmin.entities.API;
import com.mx.devJobs.pagosadmin.repository.APIRepository;
import com.mx.devJobs.pagosadmin.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class APIServiceImpl implements APIService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private APIRepository apiRepository;

    List<String> paisesDeseados = Arrays.asList("Mexico", "United States", "China", "Japan",
            "Russia", "Canada", "Argentina", "France", "South Africa", "Egypt");

    @Override
    public List<APIDTO> getApiRest() {
        APIDTO[] response = restTemplate.getForObject(basePath + "/all", APIDTO[].class);
        System.out.println("Response from API: " + restTemplate.getForObject(basePath + "/all", String.class));
        return Arrays.asList(response);
    }

    @Override
    public List<APIDTO> getApiFiltrado() {
        APIDTO[] response = restTemplate.getForObject(basePath + "/all", APIDTO[].class);
        List<APIDTO> todosLosPaises = Arrays.asList(response);

        List<APIDTO> paisesFiltrados = todosLosPaises.stream().
                filter(pais -> paisesDeseados.contains(pais.getName().getCommon()))
                .collect(Collectors.toList());
        return paisesFiltrados;
    }

    @Override
    public Response registrarPaises(APIDTO datosApi) {
        API api = new API();
        try {
            APIDTO[] response = restTemplate.getForObject(basePath + "/all", APIDTO[].class);
            List<APIDTO> todosLosPaises = Arrays.asList(response);

            Optional<APIDTO> paisObtenido = todosLosPaises.stream()
                    .filter(pais -> pais.getName().getCommon().equalsIgnoreCase(datosApi.getName().getCommon()))
                    .findFirst();

            API commonExistente = apiRepository.findByCommon(datosApi.getName().getCommon());

            if (!paisObtenido.isPresent()){ return new Response(404, "Error: Pais no encontrado"); }
            if (commonExistente != null){ return new Response(400, "Error: El pais ya fue registrado"); }
            APIDTO pais = paisObtenido.get();
            api.setCommon(pais.getName().getCommon());
            api.setOfficial(pais.getName().getOfficial());
            api.setNativeName(pais.getName().getNativeName().keySet().toString());
            NativeName nativeName = pais.getName().getNativeName().values().iterator().next();
            api.setNativeCommon(nativeName.getCommon());
            api.setNativeOfficial(nativeName.getOfficial());
            api.setTld(pais.getTld().toString());
            api.setCurrencias(pais.getCurrencies().keySet().toString());
            Currency currency = pais.getCurrencies().values().iterator().next();
            api.setCurrenciasName(currency.getName());
            api.setCurrenciasSymbol(currency.getSymbol());
            api.setCapital(pais.getCapital().toString());
            api.setRegion(pais.getRegion());
            api.setLanguage(pais.getLanguages().values().iterator().next());
            api.setFlag(pais.getFlag().toString());
            api.setMapsGoogle(pais.getMaps().getGoogleMaps());
            api.setMapsOpenStreet(pais.getMaps().getOpenStreetMaps());
            api.setFlagsPng(pais.getFlags().getPng());
            api.setFlagsSvg(pais.getFlags().getSvg());
            api.setCoatOfArmsPng(pais.getCoatOfArms().get("png").toString());
            api.setCoatOfArmsSvg(pais.getCoatOfArms().get("svg").toString());
            apiRepository.save(api);
        } catch(NullPointerException nullException) {
            return new Response(500, "Error, se encontraron valores nulos/vacios... Exception: "
                    + nullException.getMessage());
        }catch (InvalidDataAccessResourceUsageException dataException) {
            return new Response(500, "Error con acceso a la base de datos: " + dataException.getMessage());
        }catch(RestClientException restException) {
            return new Response(500, "Error al comunicarse con la API externa: " + restException.getMessage());
        } catch(Exception e) {
            return new Response(500, "Ocurrio una excepcion, con mensaje: " + e.getMessage());
        }

        return new Response(200, "Se ha registrado correctamente", api);
    }

    @Override
    public List<API> getCountryByCommon(APIDTO datosCountry) {
        return apiRepository.getFindCountry(datosCountry.getName().getCommon());
    }
}
