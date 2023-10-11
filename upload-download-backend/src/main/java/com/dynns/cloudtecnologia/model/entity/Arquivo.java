package com.dynns.cloudtecnologia.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "arquivo")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 5)
    private String extensao;

    @Lob
    @Column(nullable = false)
    private byte[] arquivoByte;

    public Arquivo(String nome, String extensao, byte[] arquivoByte) {
        this.nome = nome;
        this.extensao = extensao;
        this.arquivoByte = arquivoByte;
    }

}
