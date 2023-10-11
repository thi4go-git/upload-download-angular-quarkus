package com.dynns.cloudtecnologia.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArquivoResponseDTO {
    private Long id;
    private String nome;
    private String extensao;
}
