package org.Aston.hw2_WebService.model;

import java.util.Objects;

public class Director {
    private Long id;
    private String name;
    private String dateOfBirth;
    private int numOfMovies;

    public Director() {
    }

    public Director(Long id, String name, String dateOfBirth, int numOfMovies) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.numOfMovies = numOfMovies;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumOfMovies() {
        return numOfMovies;
    }

    public void setNumOfMovies(int numOfMovies) {
        this.numOfMovies = numOfMovies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return numOfMovies == director.numOfMovies && Objects.equals(id, director.id) &&
                Objects.equals(name, director.name) && Objects.equals(dateOfBirth, director.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, numOfMovies);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", numOfMovies=" + numOfMovies +
                '}';
    }
}
