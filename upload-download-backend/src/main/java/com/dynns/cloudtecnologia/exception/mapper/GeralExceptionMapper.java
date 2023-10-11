package com.dynns.cloudtecnologia.exception.mapper;

import com.dynns.cloudtecnologia.exception.GeralException;
import com.dynns.cloudtecnologia.rest.dto.ApplicationErrorsDTO;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@Provider
public class GeralExceptionMapper implements ExceptionMapper<GeralException> {

    private static final Logger LOGGER = Logger.getLogger(GeralExceptionMapper.class);

    @Override
    public Response toResponse(GeralException exception) {
        LOGGER.info(exception.getMessage());
        List<String> erros = new ArrayList<>();
        erros.add(exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApplicationErrorsDTO(erros))
                .build();
    }
}
