package com.dynns.cloudtecnologia.service;


import com.dynns.cloudtecnologia.model.entity.Lancamento;
import com.dynns.cloudtecnologia.rest.dto.ArquivoUploadDTO;
import java.util.List;

public interface LancamentoService {


    void salvarLancamento();

    List<Lancamento> listAll();

    void uploadArquivo(ArquivoUploadDTO arquivoUploadDTO, Long idLancamento);

    Lancamento getLancamentoById(Long idLancamento);
}
