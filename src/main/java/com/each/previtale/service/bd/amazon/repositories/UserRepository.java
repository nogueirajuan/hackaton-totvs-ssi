/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.repositories;

import com.each.previtale.service.bd.amazon.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan_
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();
    
    @Override
    User findOne(Integer idUser);
    
    User findByRg(Integer rg);
    
}
