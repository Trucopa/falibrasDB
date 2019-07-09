package ufal.com.br.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import ufal.com.br.entities.ArticulationPoint;

public class ArticulationPointController{

    EntityManagerFactory emf;
    EntityManager em;

    //Constructor
    public ArticulationPointController() {

        emf = Persistence.createEntityManagerFactory("falibrasDB");
        em = emf.createEntityManager();
    }

    //Salvar no banco
    public void save(ArticulationPoint ap){

        try {

            em.getTransaction().begin();
            em.merge(ap);
            em.getTransaction().commit();

        } catch (HibernateException he) {

            he.printStackTrace();

        }finally{

            emf.close();
        }
    }

    //Remover do banco
    public void delete(ArticulationPoint ap){

        em.getTransaction().begin();
        //Query q = em.createNativeQuery("DELETE transition FROM transition where transition_id = " + transition.getId());
        Query q = em.createNativeQuery("DELETE * FROM articulationpoint WHERE description like '" + ap.getDescription()+"'");
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

    public List<ArticulationPoint> read (){

        em.getTransaction().begin();
        Query q = em.createNativeQuery("SELECT description FROM articulationpoint");
        List<ArticulationPoint> list = q.getResultList();
        em.getTransaction().commit();
        emf.close();
        return list;
    }
/*
    public void updateByDescription(Transition transition){
        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("SELECT transition_id FROM transition WHERE description = '"+transition.getDescription()+"'");
            List<Integer> list = q.getResultList();
            if(list != null){
                transition.setId(list.get(0));
            }
            //em.getTransaction().commit();
            em.merge(transition);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }
*/
    public void updateById(ArticulationPoint ap){
        try {
            em.getTransaction().begin();
            em.merge(ap);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }
}