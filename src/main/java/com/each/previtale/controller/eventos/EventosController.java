package com.each.previtale.controller.eventos;

import com.each.previtale.facade.AvaliacoesFacade;
import com.each.previtale.facade.EventosFacade;
import com.each.previtale.service.bd.amazon.entities.Avaliacoes;
import com.each.previtale.service.bd.amazon.entities.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("eventos")
public class EventosController {

    @Autowired
    EventosFacade eventosFacade;

    @Autowired
    AvaliacoesFacade avaliacoesFacade;

    @RequestMapping("list")
    public ModelAndView getEventos() {
        ModelAndView mav = new ModelAndView("eventos/list");

        try {
            List<Eventos> eventos = eventosFacade.buscaEventos();
            mav.addObject("eventos", eventos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping("event")
    public ModelAndView getEventoByID(@Param(value = "id") Integer id) {
        ModelAndView mav = new ModelAndView("eventos/event");

        try {
            Eventos evento = eventosFacade.buscarEventoPorId(id);
            List<Avaliacoes> avaliacoes = avaliacoesFacade.buscaAvaliacoesPorIdEvento(id);



            mav.addObject("evento", evento);
            mav.addObject("avaliacoes", avaliacoes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping("cadastrar")
    public ModelAndView newEvent() {
        ModelAndView mav = new ModelAndView("eventos/cadastrar-evento");
        return mav;
    }

    @RequestMapping(value = "new-event-request", method = RequestMethod.POST)
    public ModelAndView newEventRequest(@Param(value = "nome") String nome, @Param(value = "image") File image) {
        ModelAndView mav = new ModelAndView("eventos/novo-evento");
        return mav;
    }

}
