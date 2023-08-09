package org.Aston.hw2_WebService.model;

import java.sql.Date;
import java.util.Objects;

public class Actor {
    private Long id;
    private String name;
    private Date dateOfBirth;
    private int numOfOscars;

    public Actor() {

    }

    public Actor(Long id, String name, Date dateOfBirth, int numOfOscars) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.numOfOscars = numOfOscars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.sql.Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumOfOscars() {
        return numOfOscars;
    }

    public void setNumOfOscars(int numOfOscars) {
        this.numOfOscars = numOfOscars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id, actor.id) && Objects.equals(name, actor.name) &&
                Objects.equals(dateOfBirth, actor.dateOfBirth) && Objects.equals(numOfOscars, actor.numOfOscars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, numOfOscars);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", numOfOscars=" + numOfOscars +
                '}';
    }
}
