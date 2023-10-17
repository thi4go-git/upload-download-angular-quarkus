package com.dynns.cloudtecnologia.service;

import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.rest.dto.ArquivoUploadDTO;
import java.util.List;


public interface ArquivoService {
    Arquivo save(ArquivoUploadDTO arquivoUploadDTO);

    List<Arquivo> getAll();

    Arquivo getById(Long id);
}
