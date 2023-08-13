package org.Aston.hw3_Hibernate.dao;

import org.Aston.hw3_Hibernate.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MovieDAO {
    private final SessionFactory sessionFactory;

    public MovieDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(movie);
        session.getTransaction().commit();
    }

    public Movie getById (Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Movie> movies = session.createQuery("SELECT m FROM Movie m JOIN FETCH m.actors WHERE m.id = " + id,
                Movie.class).getResultList();
        session.getTransaction().commit();
        return movies.get(0);
    }

    public Movie update (Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Movie movieMerged = session.merge(movie);
        session.getTransaction().commit();
        return movieMerged;
    }

    public void delete (Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(movie);
        session.getTransaction().commit();
    }

    public List<Movie> getAllMovies () {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Movie> movies = session.createQuery("SELECT m FROM Movie m JOIN FETCH m.actors",
                Movie.class).getResultList();
        session.getTransaction().commit();
        return movies;
    }
}
