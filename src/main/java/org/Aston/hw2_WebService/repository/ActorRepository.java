package org.Aston.hw2_WebService.repository;

import org.Aston.hw2_WebService.model.Actor;
import org.Aston.hw2_WebService.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorRepository {
    private static final String SELECT_ALL = "SELECT * FROM actors";
    private static final String INSERT = "INSERT INTO actors (name, date_of_birth, num_of_oscars) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM actors WHERE id=?";
    private static final String UPDATE_BY_ID = "UPDATE actors SET name = ?, date_of_birth=?, num_of_oscars=? WHERE id=?";
    private static final String DELETE_BY_ID = "DELETE FROM actors WHERE id=?";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
    private static final String COLUMN_NUM_OF_OSCARS = "num_of_oscars";

    public ActorRepository() {
    }

    public void add(String name, Date dateOfBirth, int numOfOscars) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, dateOfBirth);
            preparedStatement.setInt(3, numOfOscars);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Couldn't add actor");
            e.printStackTrace();
        }
    }

    public Actor get(Long id) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return createActor(resultSet);
        } catch (SQLException e) {
            System.out.println("Couldn't get actor");
            e.printStackTrace();
            return null;
        }
    }

    public void update(Long id, String name, Date dateOfBirth, int numOfOscars) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, dateOfBirth);
            preparedStatement.setInt(3, numOfOscars);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Couldn't update actor");
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Couldn't delete actor");
            e.printStackTrace();
        }
    }

    public List<Actor> getAllActors() {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Actor> actors = new ArrayList<>();
            while (resultSet.next()) {
                actors.add(createActor(resultSet));
            }
            return actors;
        } catch (SQLException e) {
            System.out.println("Couldn't get actors");
            e.printStackTrace();
            return null;
        }
    }

    private Actor createActor(ResultSet resultSet) throws SQLException {
        Actor actor = new Actor();
        actor.setId(resultSet.getLong(COLUMN_ID));
        actor.setName(resultSet.getString(COLUMN_NAME));
        actor.setDateOfBirth(Date.valueOf(resultSet.getString(COLUMN_DATE_OF_BIRTH)));
        actor.setNumOfOscars(resultSet.getInt(COLUMN_NUM_OF_OSCARS));
        return actor;
    }
}
