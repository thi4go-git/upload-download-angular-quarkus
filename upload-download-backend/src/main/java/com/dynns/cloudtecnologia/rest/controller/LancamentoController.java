package com.dynns.cloudtecnologia.rest.controller;


import com.dynns.cloudtecnologia.model.entity.Lancamento;
import com.dynns.cloudtecnologia.rest.dto.ArquivoUploadDTO;
import com.dynns.cloudtecnologia.rest.dto.LancamentoNewDTO;
import com.dynns.cloudtecnologia.rest.mapper.ArquivoMapper;
import com.dynns.cloudtecnologia.rest.mapper.LancamentoMapper;
import com.dynns.cloudtecnologia.service.impl.LancamentoServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.util.List;


@Path("/lancamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LancamentoController {


    @Inject
    private LancamentoServiceImpl lancamentoService;

    @Inject
    private LancamentoMapper lancamentoMapper;

    @Inject
    private ArquivoMapper arquivoMapper;


    @POST
    public Response newLancamento() {
        lancamentoService.salvarLancamento();
        return Response.ok().build();
    }

    @POST
    @Path("/{id}/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @MultipartForm ArquivoUploadDTO arquivoUploadDTO,
            @PathParam("id") final Long idLancamento
    ) {
        lancamentoService.uploadArquivo(arquivoUploadDTO, idLancamento);
        return Response.ok().build();
    }

    @GET
    @Path("/list")
    public Response listAll() {
        List<Lancamento> lancamentos = lancamentoService.listAll();
        return Response.ok(lancamentoMapper.listLancamentoToListLancamentoResponseDTO(lancamentos)).build();
    }

    @GET
    @Path("/{id}/download")
    public Response baixarArquivo(
            @PathParam("id") final Long idLancamento
    ) {
        Lancamento lancamento = lancamentoService.getLancamentoById(idLancamento);
        return Response.ok(arquivoMapper.lancamentoToArquivoDownloaDTO(lancamento)).build();
    }


}
