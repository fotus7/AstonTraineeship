package org.Aston.hw3_Hibernate.dao;

import org.Aston.hw3_Hibernate.model.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ActorDAO {
    private SessionFactory sessionFactory;

    public ActorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Actor actor) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(actor);
        session.getTransaction().commit();
    }

    public Actor getById (Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Actor> actors = session.createQuery("SELECT a FROM Actor a JOIN FETCH a.movies WHERE a.id = " + id,
                Actor.class).getResultList();
        session.getTransaction().commit();
        return actors.get(0);
    }

    public Actor update (Actor actor) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Actor actorMerged = session.merge(actor);
        session.getTransaction().commit();
        return actorMerged;
    }

    public void delete (Actor actor) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(actor);
        session.getTransaction().commit();
    }

    public List<Actor> getAllActors () {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Actor> actors = session.createQuery("SELECT a FROM Actor a JOIN FETCH a.movies",
                Actor.class).getResultList();
        session.getTransaction().commit();
        return actors;
    }
}
