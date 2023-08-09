package org.Aston.hw2_WebService.model;

import java.util.Objects;

public class Movie {
    private Long id;
    private String name;
    private String genre;
    private String releaseDate;
    private int moneyMade;
    private Long directorId;

    public Movie() {
    }

    public Movie(Long id, String name, String genre, String releaseDate, int moneyMade, Long directorId) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.moneyMade = moneyMade;
        this.directorId = directorId;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(int moneyMade) {
        this.moneyMade = moneyMade;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return moneyMade == movie.moneyMade && Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre) && Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(directorId, movie.directorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, releaseDate, moneyMade, directorId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", moneyMade=" + moneyMade +
                ", directorId=" + directorId +
                '}';
    }
}
