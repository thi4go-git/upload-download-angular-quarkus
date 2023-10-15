package com.dynns.cloudtecnologia.rest.controller;


import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.rest.dto.ArquivoDTO;
import com.dynns.cloudtecnologia.rest.dto.ArquivoDownloadDTO;
import com.dynns.cloudtecnologia.rest.mapper.ArquivoMapper;
import com.dynns.cloudtecnologia.service.impl.ArquivoServiceImpl;
import com.dynns.cloudtecnologia.utils.FileUtil;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.util.List;


@Path("/file")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArquivoController {


    @Inject
    private ArquivoServiceImpl arquivoService;

    @Inject
    private ArquivoMapper arquivoMapper;

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@MultipartForm ArquivoDTO arquivoDTO) {
        arquivoService.save(arquivoDTO);
        return Response.ok().build();
    }


    @GET
    @Path("/list")
    public Response getAll() {
        List<Arquivo> arquivos = arquivoService.getAll();
        return Response.ok(arquivoMapper.listArquivoToListArquivoResponseDTO(arquivos)).build();
    }

    @GET
    @Path("/{id}")
    public Response downloadFile(
            @PathParam("id") @NotBlank(message = "O campo id é obrigatório!") final Long id
    ) {
        Arquivo arquivo = arquivoService.getById(id);
        return Response.ok(arquivoMapper.arquivoToArquivoDownloadDTO(arquivo)).build();
    }


}
