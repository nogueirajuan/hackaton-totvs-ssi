/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.facade;

import com.each.previtale.service.bd.amazon.entities.Aluno;
import com.each.previtale.service.bd.amazon.entities.DiretorModalidade;
import com.each.previtale.service.bd.amazon.entities.Tecnico;
import com.each.previtale.service.bd.amazon.entities.User;
import com.each.previtale.service.bd.amazon.repositories.AlunoRepository;
import com.each.previtale.service.bd.amazon.repositories.DmRepository;
import com.each.previtale.service.bd.amazon.repositories.TecnicoRepository;
import com.each.previtale.service.bd.amazon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author juan_
 */
@Component
public class UserFacade {
    
    @Autowired
    UserRepository userRepository;   
    
    @Autowired
    AlunoRepository alunoRepository;
    
    @Autowired
    TecnicoRepository tecnicoRepository;
    
    @Autowired
    DmRepository dmRepository;
    
    public User createUser(User user){
        return userRepository.save(user);
    }
    
    public void remoteUser(Integer idUser){
        userRepository.delete(idUser);
    }
    
    public void updateUser(User user){
        userRepository.save(user);
    }
    
    public User findUserById(Integer idUser){
        return userRepository.findOne(idUser);
    }
    
    public User findUserByRg(Integer rg){
        return userRepository.findOne(rg);
    }
    
    public Tecnico createTecnico(Tecnico novoTecnico){
        return tecnicoRepository.save(novoTecnico);
    }
    
    public Aluno createAluno(Aluno novoAluno){
        return alunoRepository.save(novoAluno);
    }
    
    public DiretorModalidade createDm(DiretorModalidade novoDiretorModalidade){
        return dmRepository.save(novoDiretorModalidade);
    }
}
