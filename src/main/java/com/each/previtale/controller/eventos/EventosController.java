package com.each.previtale.controller.eventos;

import com.each.previtale.facade.EventosFacade;
import com.each.previtale.service.bd.amazon.entities.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("eventos")
public class EventosController {

    @Autowired
    EventosFacade eventosFacade;

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

}
