package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public Client findById(Long id){
        try (Session session = sessionFactory.openSession()){
            return session.get(Client.class, id);
        }
    }

    public void update(Long id, Client client){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Client savedClient = session.get(Client.class, id);
            savedClient.setName(client.getName());
            session.merge(savedClient);
            transaction.commit();
        }
    }

    public void delete(Long id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            session.flush();
            transaction.commit();
        }
    }

}
