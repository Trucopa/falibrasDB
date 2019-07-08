package ufal.com.br;

import ufal.com.br.controllers.TransitionController;
import ufal.com.br.entities.Transition;

public class Teste {
    public static void main(String[] args) {

        Transition transition = new Transition("Maluquice");

        TransitionController tc = new TransitionController();
        tc.save(transition);
        
    }
}