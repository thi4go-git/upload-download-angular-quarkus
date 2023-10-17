package com.dynns.cloudtecnologia.rest.dto;

import jakarta.ws.rs.FormParam;
import lombok.Data;

import java.io.InputStream;

@Data
public class ArquivoUploadDTO {
    @FormParam("arquivo") // Este nome deve corresponder ao nome do campo no FormData
    public InputStream inputStream; // O arquivo será recebido como um InputStream

    @FormParam("nome") // Este nome deve corresponder ao nome do campo no FormData
    public String nome;

    @FormParam("type") // Este type deve corresponder ao nome do campo type no FormData
    private String type;
}
