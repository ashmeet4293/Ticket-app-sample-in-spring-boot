package com.ticket.TicketApplication.controller;


import com.ticket.TicketApplication.entities.TicketEntity;
import com.ticket.TicketApplication.models.ScheduledTasks;
import com.ticket.TicketApplication.service.TicketDataService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/ticketdata")
public class TicketController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private TicketDataService ticketServices;


    @RequestMapping(value="", method=RequestMethod.GET)
    public String showTicketForm(){
        return "home";
    }

    @RequestMapping("/new")
    public String newProduct(Model model){
        System.out.println("Ticket DAta Entity INitialized ");
        model.addAttribute("ticketEntity", new TicketEntity());
        return "ticket";
    }

//    @ModelAttribute("TicketEntity")
//    public TicketEntity ticketEntity() {
//        return new TicketEntity();
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute TicketEntity ticketEntity){

        Date date=ticketEntity.getTimeToComplete();

LOGGER.error("DATE from HMTL form is : "+date);

        ticketServices.save(ticketEntity);
//        return "redirect:/ticket/" + ticketEntity.getTicketId();
        return "redirect:/ticketdata";
    }

//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("TicketEntity") TicketEntity ticketEntity){
//
////        User existing = userService.findByEmail(userDto.getEmail());
////        if (existing != null){
////            result.rejectValue("email", null, "There is already an account registered with that email");
////        }
////
////        if (result.hasErrors()){
////            return "registration";
////        }
//
//        ticketServices.save(ticketEntity);
//        return "Ticket inserted Successfully";
////        return "redirect:/registration?success";
//    }


}
