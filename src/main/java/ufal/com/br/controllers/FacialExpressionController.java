package ufal.com.br.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import ufal.com.br.entities.FacialExpression;

public class FacialExpressionController{

    EntityManagerFactory emf;
    EntityManager em;

    public FacialExpressionController(){
        emf = Persistence.createEntityManagerFactory("falibrasDB");
        em = emf.createEntityManager();
    }

    public void save(FacialExpression fe){

        try {

            em.getTransaction().begin();
            em.merge(fe);
            em.getTransaction().commit();

        } catch (HibernateException he) {

            he.printStackTrace();

        }finally{

            emf.close();
        }
    }

    //Remover do banco
    public void delete(FacialExpression fe){

        em.getTransaction().begin();
        //Query q = em.createNativeQuery("DELETE transition FROM transition where transition_id = " + transition.getId());
        Query q = em.createNativeQuery("DELETE facialexpression FROM facialexpression where description like '" + fe.getDescription()+"'");
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

    public List<FacialExpression> read (){

        em.getTransaction().begin();
        Query q = em.createNativeQuery("SELECT description FROM transition");
        List<FacialExpression> list = q.getResultList();
        em.getTransaction().commit();
        emf.close();
        return list;
    }

    public void updateById(FacialExpression fe){
        try {
            em.getTransaction().begin();
            em.merge(fe);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }

}