package com.dynns.cloudtecnologia.rest.mapper;

import com.dynns.cloudtecnologia.model.entity.Lancamento;
import com.dynns.cloudtecnologia.rest.dto.ArquivoDownloaDTO;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ArquivoMapper {

    public ArquivoDownloaDTO lancamentoToArquivoDownloaDTO(Lancamento lancamento) {
        ArquivoDownloaDTO arquivoDownloaDTO = new ArquivoDownloaDTO();
        arquivoDownloaDTO.setNomeArquivo(lancamento.getArquivo().getNomeArquivo());
        arquivoDownloaDTO.setTypeArquivo(lancamento.getArquivo().getTypeArquivo());
        arquivoDownloaDTO.setArquivo(lancamento.getArquivo().getArquivo());

        return arquivoDownloaDTO;
    }

}
