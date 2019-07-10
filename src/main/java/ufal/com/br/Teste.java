package ufal.com.br;

import java.util.ArrayList;
import java.util.List;

import ufal.com.br.controllers.ArticulationPointController;
import ufal.com.br.controllers.CategoryController;
import ufal.com.br.controllers.FacialExpressionController;
import ufal.com.br.controllers.HandsConfigController;
import ufal.com.br.controllers.MeaningController;
import ufal.com.br.controllers.MomentController;
import ufal.com.br.controllers.SinalController;
import ufal.com.br.controllers.TransitionController;
import ufal.com.br.entities.ArticulationPoint;
import ufal.com.br.entities.Category;
import ufal.com.br.entities.FacialExpression;
import ufal.com.br.entities.HandsConfig;
import ufal.com.br.entities.Meaning;
import ufal.com.br.entities.Sinal;
import ufal.com.br.entities.Moment;
import ufal.com.br.entities.Transition;

public class Teste {
    public static void main(String[] args) {

        //CategoryController cc = new CategoryController();
        //cc.save(new Category("Animação"));

        //MeaningController mc = new MeaningController();
        //List<Category> teste = new ArrayList<Category>();
        //Category category = new Category(1,"Animação");
        //teste.add(category);
        //Meaning meaning = new Meaning("Estou muito feliz",teste);
        //mc.save(meaning);

        SinalController sc = new SinalController();
        List<Meaning> meanings = new ArrayList<Meaning>();
        Meaning meaning = new Meaning(2,"Estou muito feliz");
        meanings.add(meaning);
        sc.save(new Sinal("Felicidade",meanings,"http://192.168.0.1"));


        //mc.save(meaning);
        

        /*
        TransitionController tc = new TransitionController();

        Transition transition = new Transition(10, "Para de gritar");

        tc.updateById(transition);
        */
        /*List<Transition> list = tc.read();

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }*/  
    }
}