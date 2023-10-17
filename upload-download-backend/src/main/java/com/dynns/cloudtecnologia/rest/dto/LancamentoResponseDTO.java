package com.dynns.cloudtecnologia.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoResponseDTO {
    private Long id;
    private String protocolo;
    private LocalDateTime dataLancamento;
    private String nomeArquivo;
}
