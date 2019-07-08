package ufal.com.br.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import ufal.com.br.entities.Transition;

public class TransitionController{

    EntityManagerFactory emf;
    EntityManager em;

    //Constructor
    public TransitionController() {

        emf = Persistence.createEntityManagerFactory("falibrasDB");
        em = emf.createEntityManager();
    }

    //Salvar no banco
    public void save(Transition transition){

        try {

            em.getTransaction().begin();
            em.merge(transition);
            em.getTransaction().commit();

        } catch (HibernateException he) {

            he.printStackTrace();

        }finally{

            emf.close();
        }
    }

    //Remover do banco
    public void delete(Transition transition){

        em.getTransaction().begin();
        //Query q = em.createNativeQuery("DELETE transition FROM transition where transition_id = " + transition.getId());
        Query q = em.createNativeQuery("DELETE transition FROM transition where description like '" + transition.getDescription()+"'");
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

    public List<Transition> read (){

        em.getTransaction().begin();
        Query q = em.createNativeQuery("SELECT description FROM transition");
        List<Transition> list = q.getResultList();
        em.getTransaction().commit();
        emf.close();
        return list;
    }

}