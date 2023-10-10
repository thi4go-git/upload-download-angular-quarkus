package com.dynns.cloudtecnologia.rest.dto;

import jakarta.ws.rs.FormParam;
import lombok.Data;

import java.io.InputStream;

@Data
public class ArquivoDTO {
    @FormParam("arquivo") // Este nome deve corresponder ao nome do campo no FormData
    public InputStream inputStream; // O arquivo será recebido como um InputStream

}
