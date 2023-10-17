package com.dynns.cloudtecnologia.service.impl;

import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.model.repository.ArquivoRepository;
import com.dynns.cloudtecnologia.service.ArquivoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ArquivoServiceImpl implements ArquivoService {

    @Inject
    private ArquivoRepository arquivoRepository;

    @Override
    @Transactional
    public Arquivo save(Arquivo arquivo) {
        arquivoRepository.persist(arquivo);
        return arquivo;
    }
}
