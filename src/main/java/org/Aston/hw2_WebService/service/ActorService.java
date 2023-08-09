package org.Aston.hw2_WebService.service;

import org.Aston.hw2_WebService.model.Actor;
import org.Aston.hw2_WebService.repository.ActorRepository;

import java.sql.Date;
import java.util.List;

public class ActorService {
    private final ActorRepository actorRepository;
    public ActorService () {
        actorRepository = new ActorRepository();
    }

    public void add (Actor actor) {
        actorRepository.add(actor.getName(), actor.getDateOfBirth(), actor.getNumOfOscars());
    }

    public Actor get (Actor actor) {
        return actorRepository.get(actor.getId());
    }

    public void update (Long id, String name, Date date, int numOfOscars) {
        actorRepository.update(id, name, date, numOfOscars);
    }

    public void delete (Long id) {
        actorRepository.delete(id);
    }

    public List<Actor> getAll () {
        return actorRepository.getAllActors();
    }

}
