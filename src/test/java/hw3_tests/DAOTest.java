package hw3_tests;

import org.Aston.hw3_Hibernate.dao.DirectorDAO;
import org.Aston.hw3_Hibernate.dao.MovieDAO;
import org.Aston.hw3_Hibernate.model.Actor;
import org.Aston.hw3_Hibernate.dao.ActorDAO;
import org.Aston.hw3_Hibernate.model.Director;
import org.Aston.hw3_Hibernate.model.Movie;
import org.Aston.hw3_Hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DAOTest {

    private static SessionFactory sessionFactory;
    private static ActorDAO actorDAO;
    private static DirectorDAO directorDAO;
    private static MovieDAO movieDAO;
    private static Actor actor;
    private static Director director;
    private static Movie movie;

    @BeforeAll
    static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        actorDAO = new ActorDAO(sessionFactory);
        directorDAO = new DirectorDAO(sessionFactory);
        movieDAO = new MovieDAO(sessionFactory);
        actor = new Actor();
        actor.setName("Actor");
        actor.setDateOfBirth(new Date(new GregorianCalendar(2013, Calendar.JUNE, 23).getTimeInMillis()));
        actor.setNumOfOscars(3);
        director = new Director();
        director.setName("Director");
        director.setDateOfBirth(new Date(new GregorianCalendar(2013, Calendar.JUNE, 23).getTimeInMillis()));
        movie = new Movie();
        movie.setName("Movie");
        movie.setGenre("Genre");
        movie.setReleaseDate(new Date(new GregorianCalendar(2013, Calendar.JUNE, 23).getTimeInMillis()));
        movie.setMoneyMade(20);
        Set<Actor> actors = new HashSet<>();
        actors.add(actor);
        Set<Movie> moviesSet = new HashSet<>();
        moviesSet.add(movie);
        List<Movie> moviesList = moviesSet.stream().toList();
        actor.setMovies(moviesSet);
        movie.setActors(actors);
        director.setMovies(moviesList);
        movie.setDirector(director);
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(actor);
        session.persist(director);
        session.persist(movie);
        transaction.commit();
    }

    @Test
    void testGet() {
        Actor actorDB = actorDAO.getById(1L);
        assertEquals(actor, actorDB);
        Director directorDB = directorDAO.getById(1L);
        assertEquals(director, directorDB);
        Movie movieDB = movieDAO.getById(1L);
        assertEquals(movie, movieDB);
    }

    @Test
    void testAdd() {
        Director director = new Director();
        director.setName("Director2");
        director.setDateOfBirth(new Date(new GregorianCalendar(2010, Calendar.JULY, 4).getTimeInMillis()));
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        director.setMovies(movies);
        directorDAO.add(director);
        List<Director> directors = directorDAO.getAllDirectors();
        assertEquals(2, directors.size());
    }

    @Test
    void testUpdate () {
        Actor newActor = actor;
        newActor.setName("New Actor");
        newActor.setDateOfBirth(new Date(new GregorianCalendar(2010, Calendar.JULY, 4).getTimeInMillis()));
        newActor.setNumOfOscars(4);
        Set<Movie> moviesSet = new HashSet<>();
        moviesSet.add(movie);
        newActor.setMovies(moviesSet);
        actorDAO.update(newActor);
        Actor actorDB = actorDAO.getById(1L);
        assertEquals(newActor, actorDB);
    }

    @AfterAll
    static void closeSessionFactory() {
        sessionFactory.close();
    }
}
