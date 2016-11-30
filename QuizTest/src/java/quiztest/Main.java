/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiztest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JelleDeBock
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Quiz myQuiz;
        try {
            myQuiz = new Quiz();
                    System.out.println(myQuiz.getQuestion().getQuestion());

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
