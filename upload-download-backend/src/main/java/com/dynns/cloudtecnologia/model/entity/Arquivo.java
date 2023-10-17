package com.dynns.cloudtecnologia.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "arquivo")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArquivo;

    @Column
    private String nomeArquivo;

    @Column(length = 100)
    private String typeArquivo;

    @Lob
    @Column
    private byte[] arquivo;
}
