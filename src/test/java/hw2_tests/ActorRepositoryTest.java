package hw2_tests;

import org.Aston.hw2_WebService.model.Actor;
import org.Aston.hw2_WebService.repository.ActorRepository;
import org.Aston.hw2_WebService.util.DataBaseConnection;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActorRepositoryTest {
    private static ActorRepository actorRepository;
    private static Actor actor;

    @BeforeAll
    static void setUp() {
        actorRepository = new ActorRepository();
        actor = new Actor(1L, "Test",
                new Date(new GregorianCalendar(2013, Calendar.JUNE, 23).getTimeInMillis()), 5);
    }

    @Test
    @Order(1)
    void testAdd() {
        actorRepository.add(actor.getName(), actor.getDateOfBirth(), actor.getNumOfOscars());
        List<Actor> actors = actorRepository.getAllActors();
        assertNotEquals(0, actors.size());
        assertEquals(1, actors.size());
        Actor actorFromDB = actors.get(0);
        assertEquals(actor, actorFromDB);
    }

    @Test
    @Order(2)
    void testGet() {
        Actor actorFromDB = actorRepository.get(1L);
        assertEquals(actor, actorFromDB);
    }

    @Test
    @Order(3)
    void testUpdate() {
        actor = new Actor(1L, "Test1",
                new Date(new GregorianCalendar(2013, Calendar.JULY, 1).getTimeInMillis()), 3);
        actorRepository.update(1L, "Test1", (Date)
                new Date(new GregorianCalendar(2013, Calendar.JULY, 1).getTimeInMillis()), 3);
        Actor actorFromDB = actorRepository.get(1L);
        assertEquals(actor, actorFromDB);
    }

    @Test
    @Order(4)
    void testDelete() {
        actorRepository.delete(1L);
        List<Actor> actors = actorRepository.getAllActors();
        assertEquals(0, actors.size());
    }

    @AfterAll
    static void clearDataBase() {
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE TABLE actors RESTART IDENTITY CASCADE ;");
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }
}
