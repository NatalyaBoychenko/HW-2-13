package org.example.service;

import org.example.dao.TicketDao;
import org.example.model.Ticket;

public class TicketCrudService {
    private TicketDao ticketDao = new TicketDao();

    public void saveTicket(Ticket ticket){
        ticketDao.save(ticket);
    }

    public Ticket findTicketById(Long id){
        return ticketDao.findById(id);
    }

    public void updateTicket(Long id, Ticket ticket){
        ticketDao.update(id, ticket);
    }

    public void deleteTicket(Long id){
        ticketDao.delete(id);
    }
}
