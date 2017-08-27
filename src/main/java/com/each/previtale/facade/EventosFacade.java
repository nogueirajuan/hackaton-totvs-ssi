package com.each.previtale.facade;

import com.each.previtale.service.bd.amazon.entities.Eventos;
import com.each.previtale.service.bd.amazon.repositories.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class EventosFacade {

    private static final Logger log = Logger.getLogger(EventosFacade.class.getName());

    @Autowired
    EventosRepository eventosRepository;

    public void cadastraEvento(Eventos evento) {
        try {
            eventosRepository.save(evento);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[CADASTRAR-EVENTO]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public void atualizarEvento(Eventos evento) {
        try {
            eventosRepository.save(evento);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[ATUALIZAR-EVENTO]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public void apagarEvento(Integer idEvento) {
        try {
            eventosRepository.delete(idEvento);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[APAGAR-EVENTO]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public void buscarEventoPorId(Integer idEvento) {
        try {
            eventosRepository.findByIdEvento(idEvento);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[BUSCAR-EVENTO-POR-ID]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public List<Eventos> buscaEventos() throws Exception {
        try {
            return eventosRepository.findAll();
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[BUSCA-EVENTOS]-[EXCEPTION]-[{}]", e.getMessage());
            throw new Exception (e.getMessage());
        }
    }

    public void buscarEventoPorFiltro(String tipo, String endereco) {
        try {

        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[BUSCAR-EVENTO-POR-ID]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

}
