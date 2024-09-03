package com.mx.devJobs.pagosadmin.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class APIDTO {
    private Name name;
    private List<String> tld;
    private Map<String, Currency> currencies;
    private List<String> capital;
    private String region;
    private Map<String, String> languages;
    private String flag;
    private Maps maps;
    private Flags flags;
    private Map<String, String> coatOfArms;

}
