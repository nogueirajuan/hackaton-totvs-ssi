package com.each.previtale.service.bd.amazon.repositories;

import com.each.previtale.service.bd.amazon.entities.Eventos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventosRepository extends CrudRepository<Eventos, Integer> {

    @Override
    public List<Eventos> findAll();

    @Override
    public Eventos findOne(Integer id);

}
