package com.each.previtale.facade;

import com.each.previtale.service.bd.amazon.entities.Avaliacoes;
import com.each.previtale.service.bd.amazon.entities.Eventos;
import com.each.previtale.service.bd.amazon.repositories.AvaliacoesRepository;
import com.each.previtale.service.bd.amazon.repositories.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AvaliacoesFacade {

    private static final Logger log = Logger.getLogger(AvaliacoesFacade.class.getName());

    @Autowired
    AvaliacoesRepository avaliacoesRepository;

    public void cadastraAvaliacao(Avaliacoes avaliacao) {
        try {
            avaliacoesRepository.save(avaliacao);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[CADASTRAR-AVALIACAO]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

    public List<Avaliacoes> buscaAvaliacoesPorIdEvento(Integer idEvento) throws Exception {
        try{
            Eventos evento = new Eventos();
            evento.setIdEvento(idEvento);

            //return avaliacoesRepository.findByIdEvento(evento);
            List<Avaliacoes> avaliacoes = avaliacoesRepository.findByEventosIdEvento(evento);
            log.log(Level.INFO, "[HACKATHON]-[BUSCA-AVALIACAO-POR-EVENTO]-[AVALIACOES]-[" + avaliacoes + "]");
            return avaliacoes;
        }catch(Exception e){
            log.log(Level.INFO, "[HACKATHON]-[BUSCA-AVALIACAO-POR-EVENTO]-[EXCEPTION]-[{}]", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public void atualizarAvaliacao(Avaliacoes avaliacao) throws Exception {
        try {
            avaliacoesRepository.save(avaliacao);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[ATUALIZAR-AVALIACAO]-[EXCEPTION]-[{}]", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public void apagarAvaliacao(Integer idAvaliacao) {
        try {
            avaliacoesRepository.delete(idAvaliacao);
        } catch (Exception e) {
            log.log(Level.INFO, "[HACKATHON]-[APAGAR-AVALIACAO]-[EXCEPTION]-[{}]", e.getMessage());
        }
    }

}
