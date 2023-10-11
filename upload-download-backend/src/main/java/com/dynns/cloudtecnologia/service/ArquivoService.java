package com.dynns.cloudtecnologia.service;

import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.rest.dto.ArquivoDTO;
import java.util.List;


public interface ArquivoService {
    Arquivo save(ArquivoDTO arquivoDTO);

    List<Arquivo> getAll();

    Arquivo getById(Long id);
}
