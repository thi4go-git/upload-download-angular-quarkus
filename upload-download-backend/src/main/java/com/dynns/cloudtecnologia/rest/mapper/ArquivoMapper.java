package com.dynns.cloudtecnologia.rest.mapper;

import com.dynns.cloudtecnologia.model.entity.Arquivo;
import com.dynns.cloudtecnologia.rest.dto.ArquivoDownloadDTO;
import com.dynns.cloudtecnologia.rest.dto.ArquivoResponseDTO;
import com.dynns.cloudtecnologia.utils.FileUtil;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ArquivoMapper {

    public ArquivoResponseDTO arquivoToArquivoResponseDTO(Arquivo arquivo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(arquivo, ArquivoResponseDTO.class);
    }

    public List<ArquivoResponseDTO> listArquivoToListArquivoResponseDTO(final List<Arquivo> arquivos) {
        return arquivos.stream().map(this::arquivoToArquivoResponseDTO).collect(Collectors.toList());
    }


    public ArquivoDownloadDTO arquivoToArquivoDownloadDTO(Arquivo arquivo) {
        ModelMapper modelMapper = new ModelMapper();
        ArquivoDownloadDTO arquivoDownloadDTO = modelMapper.map(arquivo, ArquivoDownloadDTO.class);
        arquivoDownloadDTO.setInputStream(FileUtil.byteArrayToInputStream(arquivo.getArquivoByte()));

        return arquivoDownloadDTO;
    }

}
