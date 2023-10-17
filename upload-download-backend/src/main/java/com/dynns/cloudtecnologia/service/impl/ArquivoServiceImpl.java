package com.dynns.cloudtecnologia.service.impl;

import com.dynns.cloudtecnologia.exception.GeralException;
import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.model.repository.ArquivoRepository;
import com.dynns.cloudtecnologia.rest.dto.ArquivoUploadDTO;
import com.dynns.cloudtecnologia.service.ArquivoService;
import com.dynns.cloudtecnologia.utils.FileUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.List;


@ApplicationScoped
public class ArquivoServiceImpl implements ArquivoService {


    @Inject
    private ArquivoRepository arquivoRepository;

    @Override
    @Transactional
    public Arquivo save(ArquivoUploadDTO arquivoUploadDTO) {
        Arquivo arquivo = new Arquivo();
        arquivo.setNome(arquivoUploadDTO.getNome());
        try {
            arquivo.setArquivo(FileUtil.inputStreamToByteArray(arquivoUploadDTO.getInputStream()));
            arquivo.setType(arquivoUploadDTO.getType());
        } catch (IOException e) {
            throw new GeralException("Erro ao converter InputStream to ByteArray[]");
        }
        arquivoRepository.persist(arquivo);
        return arquivo;
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
