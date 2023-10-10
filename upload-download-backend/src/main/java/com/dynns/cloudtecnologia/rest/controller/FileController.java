package com.dynns.cloudtecnologia.rest.controller;


import com.dynns.cloudtecnologia.rest.dto.ArquivoDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;


@Path("/file")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FileController {

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@MultipartForm ArquivoDTO arquivoDTO) {
        // Lide com o arquivo recebido aqui
        // O arquivo estará disponível em form.getFile() como um objeto File
        return Response.ok(arquivoDTO.getInputStream()).build();
    }


}
