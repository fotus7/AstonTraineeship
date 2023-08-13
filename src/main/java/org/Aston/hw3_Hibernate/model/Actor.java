package org.Aston.hw3_Hibernate.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "num_of_oscars", nullable = false)
    private int numOfOscars;
    @ManyToMany
    private Set<Movie> movies = new HashSet<>();

    public Actor() {
    }

    public Actor(Long id, String name, Date dateOfBirth, int numOfOscars, Set<Movie> movies) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.numOfOscars = numOfOscars;
        this.movies = movies;
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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return numOfOscars == actor.numOfOscars && Objects.equals(id, actor.id) && Objects.equals(name, actor.name) &&
                Objects.equals(dateOfBirth, actor.dateOfBirth) && Objects.equals(movies.size(), actor.movies.size());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", numOfOscars=" + numOfOscars +
                ", movies=" + movies +
                '}';
    }
}
