package ufal.com.br.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import ufal.com.br.entities.HandsConfig;

public class HandsConfigController{
    EntityManagerFactory emf;
    EntityManager em;

    public HandsConfigController (){
        emf = Persistence.createEntityManagerFactory("falibrasDB");
        em = emf.createEntityManager();
    }

    public void save(HandsConfig hc){

        try {

            em.getTransaction().begin();
            em.merge(hc);
            em.getTransaction().commit();

        } catch (HibernateException he) {

            he.printStackTrace();

        }finally{

            emf.close();
        }
    }

    //Remover do banco
    public void delete(HandsConfig hc){

        em.getTransaction().begin();
        //Query q = em.createNativeQuery("DELETE transition FROM transition where transition_id = " + transition.getId());
        Query q = em.createNativeQuery("DELETE * FROM handsconfig where description like '" + hc.getDescription()+"'");
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

    public List<HandsConfig> read (){

        em.getTransaction().begin();
        Query q = em.createNativeQuery("SELECT description FROM handsconfig");
        List<HandsConfig> list = q.getResultList();
        em.getTransaction().commit();
        emf.close();
        return list;
    }

    public void updateById(HandsConfig hc){
        try {
            em.getTransaction().begin();
            em.merge(hc);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }
}