package com.ticket.TicketApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="")
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
//    @RequestMapping(value="/test", method= RequestMethod.GET)
//    public String showTicketForm(Model model){
//        return "ticket";
//    }


}
