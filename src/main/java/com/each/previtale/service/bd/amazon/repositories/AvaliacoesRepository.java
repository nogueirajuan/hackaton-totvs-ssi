package com.each.previtale.service.bd.amazon.repositories;

import com.each.previtale.service.bd.amazon.entities.Avaliacoes;
import com.each.previtale.service.bd.amazon.entities.Eventos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvaliacoesRepository extends CrudRepository<Avaliacoes, Integer> {

    @Override
    public List<Avaliacoes> findAll();

    public List<Avaliacoes> findByEventosIdEvento(Eventos idEvento);

}
