package com.dynns.cloudtecnologia.rest.dto;


import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ArquivoDownloadDTO {
    private Long id;
    private String nome;
    private String extensao;

    @FormParam("arquivo") // Este nome deve corresponder ao nome do campo no FormData
    private InputStream inputStream; // O arquivo será recebido como um InputStream
}
