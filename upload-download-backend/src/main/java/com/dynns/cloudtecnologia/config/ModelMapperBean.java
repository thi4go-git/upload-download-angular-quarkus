package com.dynns.cloudtecnologia.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;


@ApplicationScoped
public class ModelMapperBean {
    public static ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
