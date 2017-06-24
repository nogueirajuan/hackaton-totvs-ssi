/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author juan_
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    
    @RequestMapping("/home")
    public String homePage(){
        return "index";
    }
    
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}
