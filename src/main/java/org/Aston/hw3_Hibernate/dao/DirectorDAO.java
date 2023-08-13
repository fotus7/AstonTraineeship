package org.Aston.hw3_Hibernate.dao;

import org.Aston.hw3_Hibernate.model.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DirectorDAO {

    private SessionFactory sessionFactory;

    public DirectorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Director director) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(director);
        session.flush();
        session.getTransaction().commit();
    }

    public Director getById (Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Director> directors = session.createQuery("SELECT d FROM Director d JOIN FETCH d.movies WHERE d.id = " + id,
                Director.class).getResultList();
        session.getTransaction().commit();
        return directors.get(0);
    }

    public Director update (Director movie) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Director directorMerged = session.merge(movie);
        session.getTransaction().commit();
        return directorMerged;
    }

    public void delete (Director director) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(director);
        session.getTransaction().commit();
    }

    public List<Director> getAllDirectors () {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Director> directors = session.createQuery("SELECT d FROM Director d JOIN FETCH d.movies",
                Director.class).getResultList();
        session.getTransaction().commit();
        return directors;
    }
}
