package com.dynns.cloudtecnologia.service.impl;


import com.dynns.cloudtecnologia.exception.GeralException;
import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.model.entity.Lancamento;
import com.dynns.cloudtecnologia.model.repository.LancamentoRepository;
import com.dynns.cloudtecnologia.rest.dto.ArquivoDownloaDTO;
import com.dynns.cloudtecnologia.rest.dto.ArquivoUploadDTO;
import com.dynns.cloudtecnologia.rest.mapper.LancamentoMapper;
import com.dynns.cloudtecnologia.service.LancamentoService;
import com.dynns.cloudtecnologia.utils.FileUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@ApplicationScoped
@Slf4j
public class LancamentoServiceImpl implements LancamentoService {


    @Inject
    private LancamentoRepository lancamentoRepository;

    @Inject
    private ArquivoServiceImpl arquivoService;

    @Inject
    private LancamentoMapper lancamentoMapper;


    @Override
    @Transactional
    public void salvarLancamento() {
        Lancamento lancamento = lancamentoMapper.newLancamento();
        lancamentoRepository.persist(lancamento);
    }

    @Override
    public List<Lancamento> listAll() {
        return lancamentoRepository.listAll();
    }

    @Override
    @Transactional
    public void uploadArquivo(ArquivoUploadDTO arquivoUploadDTO, Long idLancamento) {
        Arquivo arquivo = new Arquivo();
        arquivo.setNomeArquivo(arquivoUploadDTO.getNome());
        arquivo.setTypeArquivo(arquivoUploadDTO.getType());
        try {
            arquivo.setArquivo(FileUtil.inputStreamToByteArray(arquivoUploadDTO.getInputStream()));
        } catch (IOException e) {
            throw new GeralException("Erro ao converter Stream para ByteArray");
        }

        arquivoService.save(arquivo);

        Lancamento lancamento = lancamentoRepository.findById(idLancamento);
        lancamento.setArquivo(arquivo);
    }

    @Override
    public Lancamento getLancamentoById(Long idLancamento) {
        return lancamentoRepository.findById(idLancamento);
    }


}
