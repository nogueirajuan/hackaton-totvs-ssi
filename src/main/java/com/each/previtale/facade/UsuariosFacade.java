package com.each.previtale.facade;

import com.each.previtale.service.bd.amazon.entities.Eventos;
import com.each.previtale.service.bd.amazon.entities.Usuarios;
import com.each.previtale.service.bd.amazon.repositories.EventosRepository;
import com.each.previtale.service.bd.amazon.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosFacade {

    private static final Logger log = Logger.getLogger(UsuariosFacade.class.getName());

    @Autowired
    UsuariosRepository usuariosRepository;

    public void cadastraUsuario(Usuarios usuarios) {
        try {
            usuariosRepository.save(usuarios);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[CADASTRAR-USUARIOS]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public void atualizarUsuario(Usuarios usuarios) {
        try {
            usuariosRepository.save(usuarios);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[ATUALIZAR-USUARIOS]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public void apagarUsuario(Integer idUsuario) {
        try {
            usuariosRepository.delete(idUsuario);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[APAGAR-USUARIO]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public void buscarUsuarioorId(Integer idUsuario) {
        try {
            usuariosRepository.findByIdUsuario(idUsuario);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[BUSCAR-USUARIO-POR-ID]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

}
