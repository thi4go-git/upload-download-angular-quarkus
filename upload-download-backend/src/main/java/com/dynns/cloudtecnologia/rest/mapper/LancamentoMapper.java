package com.dynns.cloudtecnologia.rest.mapper;

import com.dynns.cloudtecnologia.config.ModelMapperBean;
import com.dynns.cloudtecnologia.model.entity.Lancamento;
import com.dynns.cloudtecnologia.rest.dto.LancamentoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class LancamentoMapper {


    public Lancamento newLancamento() {
        UUID randomUUID = UUID.randomUUID();

        Lancamento lancamento = new Lancamento();
        lancamento.setProtocolo(randomUUID.toString());
        lancamento.setDataLancamento(LocalDateTime.now());


        return lancamento;
    }


    public LancamentoResponseDTO lancamentoToLancamentoResponseDTO(Lancamento lancamento) {
        LancamentoResponseDTO dto = ModelMapperBean.getModelMapper().map(lancamento, LancamentoResponseDTO.class);
        if (Objects.nonNull(lancamento.getArquivo())) {
            dto.setNomeArquivo(lancamento.getArquivo().getNomeArquivo());
        }
        log.info("::: " + lancamento.toString());
        return dto;
    }

    public List<LancamentoResponseDTO> listLancamentoToListLancamentoResponseDTO(List<Lancamento> lancamentos) {
        return lancamentos.stream().map(this::lancamentoToLancamentoResponseDTO).collect(Collectors.toList());
    }
}
