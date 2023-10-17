package com.dynns.cloudtecnologia.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Data
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String protocolo;

    private LocalDateTime dataLancamento;

    @OneToOne
    @JoinColumn(name = "id_arquivo")
    private Arquivo arquivo;

}
