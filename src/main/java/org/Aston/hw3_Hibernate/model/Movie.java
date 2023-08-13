package org.Aston.hw3_Hibernate.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Director director;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "genre")
    private String genre;
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;
    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;
    @Column(name = "money_made", nullable = false)
    private int moneyMade;

    public Movie() {
    }

    public Movie(Long id, Director director, String name, String genre, Date releaseDate, Set<Actor> actors, int moneyMade) {
        this.id = id;
        this.director = director;
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.moneyMade = moneyMade;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public int getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(int moneyMade) {
        this.moneyMade = moneyMade;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return moneyMade == movie.moneyMade && Objects.equals(id, movie.id) &&
                Objects.equals(director.getId(), movie.director.getId()) && Objects.equals(name, movie.name) &&
                Objects.equals(genre, movie.genre) && Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", moneyMade=" + moneyMade +
                ", director=" + director.getName() +
                '}';
    }
}
