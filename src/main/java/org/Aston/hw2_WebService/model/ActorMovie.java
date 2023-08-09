package org.Aston.hw2_WebService.model;

import java.util.Objects;

public class ActorMovie {
    private Long id;
    private Long actorId;
    private Long movieId;

    public ActorMovie() {
    }

    public ActorMovie(Long id, Long actorId, Long movieId) {
        this.id = id;
        this.actorId = actorId;
        this.movieId = movieId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorMovie that = (ActorMovie) o;
        return Objects.equals(id, that.id) && Objects.equals(actorId, that.actorId) && Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actorId, movieId);
    }

    @Override
    public String toString() {
        return "ActorMovie{" +
                "id=" + id +
                ", actorId=" + actorId +
                ", movieId=" + movieId +
                '}';
    }
}
