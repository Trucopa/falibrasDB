package ufal.com.br.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ufal.com.br.entities.Transition;

public class TransitionController{

    EntityManagerFactory emf;
    EntityManager em;

    //Constructor
    public TransitionController() {
        emf = Persistence.createEntityManagerFactory("falibrasDB");
        em = emf.createEntityManager();
    }

    public void save(Transition transition){
        em.getTransaction().begin();
        em.merge(transition);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Transition transition){
        em.getTransaction().begin();
        Query q = em.createNamedQuery("DELETE transition FROM transition where id = " + transition.getId());
        em.getTransaction().commit();
        emf.close();
    }

}