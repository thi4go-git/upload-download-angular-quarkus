package com.dynns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoResponseDTO {
    private Long id;
    private String nome;
    private String type;
}
