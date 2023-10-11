package com.dynns.cloudtecnologia.model.repository;

import com.dynns.cloudtecnologia.exception.GeralException;
import com.dynns.cloudtecnologia.model.entity.Arquivo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArquivoRepository implements PanacheRepository<Arquivo> {
    public Arquivo findByIdOrThrow(Long id) {
        return find("id =:id",
                Parameters.with("id", id)).
                firstResultOptional()
                .orElseThrow(
                        () -> new GeralException("Arquivo com id " + id + " Não localizado! "));
    }
}
