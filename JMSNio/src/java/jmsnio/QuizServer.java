/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsnio;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author JelleDeBock
 */
public class QuizServer {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, Exception {
        // TODO code application logic here
        System.out.println("Hallo from QuizServer");
        ExecutorService executor = Executors.newCachedThreadPool();
        QuestionManager questionManager = new QuestionManager();
        
        executor.execute(new ClientServer(questionManager));
        executor.execute(questionManager);
    }
    
}
