package com.dynns.cloudtecnologia.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class ArquivoDownloadDTO {
    private Long id;
    private String nome;
    private String type;
    private byte[] arquivo;
}
