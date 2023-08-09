package org.Aston.hw2_WebService.servlet;

import org.Aston.hw2_WebService.model.Actor;
import org.Aston.hw2_WebService.service.ActorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/ActorServlet")
public class ActorServlet extends HttpServlet {
    private final ActorService actorService;

    public ActorServlet() {
        this.actorService = new ActorService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null){
            Long id = Long.valueOf(req.getParameter("id"));
        }
        else actorService.getAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date dateOfBirth = Date.valueOf(req.getParameter("date"));
        int numOfOscars = Integer.parseInt(req.getParameter("numOfOscars"));
        Actor actor = new Actor();
        actor.setName(name);
        actor.setDateOfBirth(dateOfBirth);
        actor.setNumOfOscars(numOfOscars);
        actorService.add(actor);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Date dateOfBirth = Date.valueOf(req.getParameter("date"));
        int numOfOscars = Integer.parseInt(req.getParameter("numOfOscars"));
        actorService.update(id, name, dateOfBirth, numOfOscars);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        actorService.delete(id);
    }
}
