package com.ticket.TicketApplication.models;

import com.ticket.TicketApplication.entities.TicketEntity;
import com.ticket.TicketApplication.service.TicketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {
    @Autowired
    TicketDataService ticketDataService;



    List<TicketEntity> ticketEntities = new ArrayList<>();

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        Date currentDate = new Date();
        long currentTime = Math.abs(currentDate.getTime());


        log.warn("The time is NOW : "+TimeUnit.MINUTES.toDays(currentTime));
        ticketEntities = ticketDataService.getAllTickets();

        for (TicketEntity ticketEntity : ticketEntities) {
//            log.warn("Ticket Status : "+ticketEntity.getIsActive());

            if (ticketEntity.getTimeToComplete() != null && ticketEntity.getIsActive().equals("yes")) {
                Date dueDate=ticketEntity.getTimeToComplete();
                long timeDiff = Math.abs(currentDate.getTime() - dueDate.getTime());
                if(TimeUnit.MINUTES.toDays(timeDiff) < 50L){
                    log.error("YOU are going to expire in 50 seconds : "+ticketEntity.getAssignedTo());
                    ticketEntity.setIsActive("No");
                    ticketDataService.update(ticketEntity);
                    return;
                }
                log.warn("DEADLINE TIME: "+TimeUnit.MINUTES.toDays(Math.abs(dueDate.getTime()))+" OF : "+ticketEntity.getAssignedTo());
                log.warn("REMAINING TIME : " +  TimeUnit.MINUTES.toDays(timeDiff)+" OF : "+ticketEntity.getAssignedTo());

//                log.info("TicketEnttiy is : " + ticketEntity.getTimeToComplete() + " Of : " + ticketEntity.getAssignedTo()+" REMAINGIN TIME : "+String.format("%d date(s) ", TimeUnit.MINUTES.toDays(timeDiff)));
            }

        }
    }
}