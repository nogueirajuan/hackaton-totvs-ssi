package com.each.previtale.service.bd.amazon.repositories;

import com.each.previtale.service.bd.amazon.entities.Eventos;
import com.each.previtale.service.bd.amazon.entities.Usuarios;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuariosRepository extends CrudRepository<Usuarios, Integer> {

    @Override
    public List<Usuarios> findAll();

    public Usuarios findByIdUsuario(Integer idUsuario);

}
