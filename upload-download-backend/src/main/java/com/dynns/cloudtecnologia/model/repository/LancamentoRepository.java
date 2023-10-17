package com.dynns.cloudtecnologia.model.repository;

import com.dynns.cloudtecnologia.model.entity.Lancamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LancamentoRepository implements PanacheRepository<Lancamento> {
}
