package ufal.com.br.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import ufal.com.br.entities.Category;

public class CategoryController {

    EntityManagerFactory emf;
    EntityManager em;

    //Constructor
    public CategoryController() {

        emf = Persistence.createEntityManagerFactory("falibrasDB");
        em = emf.createEntityManager();
    }

    //Salvar no banco
    public void save(Category category){

        try {

            em.getTransaction().begin();
            em.merge(category);
            em.getTransaction().commit();

        } catch (HibernateException he) {

            he.printStackTrace();

        }finally{

            emf.close();
        }
    }

    //Remover do banco
    public void delete(Category category){

        em.getTransaction().begin();
        //Query q = em.createNativeQuery("DELETE transition FROM transition where transition_id = " + transition.getId());
        Query q = em.createNativeQuery("DELETE * FROM category where name like '" + category.getName()+"'");
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

    public List<Category> read (){

        em.getTransaction().begin();
        Query q = em.createNativeQuery("SELECT name FROM category");
        List<Category> list = q.getResultList();
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
    public void updateById(Category category){
        try {
            em.getTransaction().begin();
            em.merge(category);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }
}