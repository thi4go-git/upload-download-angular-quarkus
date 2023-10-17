package com.dynns.cloudtecnologia.rest.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoDownloaDTO {
    private String nomeArquivo;
    private String typeArquivo;
    private byte[] arquivo;
}
