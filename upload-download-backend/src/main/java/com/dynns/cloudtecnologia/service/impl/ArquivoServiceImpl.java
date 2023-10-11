package com.dynns.cloudtecnologia.service.impl;

import com.dynns.cloudtecnologia.exception.GeralException;
import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.model.repository.ArquivoRepository;
import com.dynns.cloudtecnologia.rest.dto.ArquivoDTO;
import com.dynns.cloudtecnologia.service.ArquivoService;
import com.dynns.cloudtecnologia.utils.FileUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@ApplicationScoped
public class ArquivoServiceImpl implements ArquivoService {


    @Inject
    private ArquivoRepository arquivoRepository;

    @Override
    @Transactional
    public Arquivo save(ArquivoDTO arquivoDTO) {
        String[] quebraNome = arquivoDTO.getNome().split("\\.");
        try {
            Arquivo arquivo = new Arquivo();
            arquivo.setNome(quebraNome[0].trim());
            arquivo.setExtensao(quebraNome[1].trim());
            arquivo.setArquivoByte(FileUtils.inputStreamToByteArray(arquivoDTO.getInputStream()));

            arquivoRepository.persist(arquivo);
            return arquivo;
        } catch (IOException e) {
            throw new GeralException("Erro ao converter InputStream to Byte[]");
        }
    }

    @Override
    public List<Arquivo> getAll() {
        return arquivoRepository.findAll().list();
    }

    @Override
    public Arquivo getById(Long id) {
        return arquivoRepository.findByIdOrThrow(id);
    }
}
