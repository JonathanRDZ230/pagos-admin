package com.mx.devJobs.pagosadmin.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "REST_COUNTRIES_API", schema = "JONATHAN_R")
public class API {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceRestCountries")
    @SequenceGenerator(name = "sequenceRestCountries", sequenceName = "SEQ_REST_COUNTRIES_API", allocationSize = 1)
    @Column(name = "ID_COUNTRY")
    private Long idCountry;
    @Column(name = "COMMON")
    private String common;
    @Column(name = "OFFICIAL")
    private String official;
    @Column(name = "NATIVE_NAME")
    private String nativeName;
    @Column(name = "NATIVE_OFFICIAL")
    private String nativeOfficial;
    @Column(name = "NATIVE_COMMON")
    private String nativeCommon;
    @Column(name = "TLD")
    private String tld;
    @Column(name = "CURRENCIAS")
    private String currencias;
    @Column(name = "CURRENCIAS_NAME")
    private String currenciasName;
    @Column(name = "CURRENCIAS_SYMBOL")
    private String currenciasSymbol;
    @Column(name = "CAPITAL")
    private String capital;
    @Column(name = "REGION")
    private String region;
    @Column(name = "LANGUAGES")
    private String language;
    @Column(name = "FLAG")
    private String flag;
    @Column(name = "MAPS_GOOGLE")
    private String mapsGoogle;
    @Column(name = "MAPS_OPEN_STREET")
    private String mapsOpenStreet;
    @Column(name = "FLAGS_PNG")
    private String flagsPng;
    @Column(name = "FLAGS_SVG")
    private String flagsSvg;
    @Column(name = "COAT_OF_ARMS_PNG")
    private String coatOfArmsPng;
    @Column(name = "COAT_OF_ARMS_SVG")
    private String coatOfArmsSvg;


}
