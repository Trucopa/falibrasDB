package ufal.com.br;

import java.util.List;

import ufal.com.br.controllers.TransitionController;
import ufal.com.br.entities.Transition;

public class Teste {
    public static void main(String[] args) {
    
        TransitionController tc = new TransitionController();

        Transition transition = new Transition("Levanta mão esquerda");

        tc.save(transition);
        
        /*List<Transition> list = tc.read();

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }*/  
    }
}