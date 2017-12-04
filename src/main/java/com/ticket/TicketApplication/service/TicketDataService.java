package com.ticket.TicketApplication.service;


import com.ticket.TicketApplication.entities.TicketEntity;
import com.ticket.TicketApplication.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketDataService {
    @Autowired
    TicketRepository ticketRepository;

    public List<TicketEntity> getAllTickets(){
        List<TicketEntity> ticketEntities=new ArrayList<>();

        ticketEntities=ticketRepository.findAll();

        return ticketEntities;

    }
    public TicketEntity getTicketById(Integer id){
        TicketEntity ticketEntity=ticketRepository.findOne(id);
        return ticketEntity;
    }

    public TicketEntity save(TicketEntity ticketEntity) {

        TicketEntity ticketEntity1=new TicketEntity();
        ticketEntity1= ticketRepository.save(ticketEntity);
        return ticketEntity1;

    }
    public TicketEntity update(TicketEntity ticketEntity){
        TicketEntity ticketEntity1=ticketRepository.findOne(ticketEntity.getTicketId());

        TicketEntity savedTicket=new TicketEntity();
        if(ticketEntity1!=null){
             savedTicket = ticketRepository.save(ticketEntity);
        }
        return savedTicket;
    }
}
