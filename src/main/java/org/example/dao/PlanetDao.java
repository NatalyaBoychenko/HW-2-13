package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetDao {

    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save (Planet planet){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet findById(String id){
        try(Session session = sessionFactory.openSession()){
            return session.get(Planet.class, id);
        }
    }

    public void update (String id, Planet planet){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Planet savedPlanet = session.get(Planet.class, id);
            savedPlanet.setName(planet.getName());
            session.merge(savedPlanet);
            transaction.commit();
        }
    }

    public void delete(String id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            session.remove(planet);
            transaction.commit();
        }
    }

}
