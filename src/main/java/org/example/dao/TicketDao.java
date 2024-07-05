package org.example.dao;

import org.example.HibernateUtil;
import org.example.exception.BadClientRequestException;
import org.example.exception.BadPlanetRequestException;
import org.example.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {

    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Ticket ticket){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            if (ticket.getClient() == null){
                throw new BadClientRequestException();
            }
            if (ticket.getFromPlanetId() == null || ticket.getToPlanetId() == null){
                throw new BadPlanetRequestException();
            }
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket findById(Long id){
        try(Session session = sessionFactory.openSession()){
            return session.get(Ticket.class, id);
        }
    }

    public void update(Long id, Ticket ticket){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Ticket savedTicket = session.get(Ticket.class, id);
            if (ticket.getClient() == null){
                throw new BadClientRequestException();
            }
            if (ticket.getFromPlanetId() == null || ticket.getToPlanetId() == null){
                throw new BadPlanetRequestException();
            }
            savedTicket.setClient(ticket.getClient());
            savedTicket.setCreatedAt(ticket.getCreatedAt());
            savedTicket.setFromPlanetId(ticket.getFromPlanetId());
            savedTicket.setToPlanetId(ticket.getToPlanetId());
            session.merge(savedTicket);
            transaction.commit();
        }
    }

    public void delete(Long id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            session.remove(ticket);
            transaction.commit();
        }
    }
}
