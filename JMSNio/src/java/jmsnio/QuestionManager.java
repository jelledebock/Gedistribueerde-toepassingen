/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsnio;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelle
 */
class QuestionManager implements Runnable{
    private Map<Client, Socket> clients;

    public QuestionManager() {
        clients = new HashMap<>();
    }
    
    public void addClientToSubscriberList(Client client, Socket sock){
        clients.put(client, sock);
    }

    @Override
    public void run() {
        while(true){
            //Get the question
            Quiz quiz;
            try {
                quiz = new Quiz();
                Question question = quiz.getQuestion();
                for (Map.Entry<Client, Socket> entry : clients.entrySet()) {
                    Client key = entry.getKey();
                    Socket socket = entry.getValue();
                    String questionStr="[id="+question.getId()+"]"+question.getQuestion()+"\n";

                    System.out.println("Sending question to client "+key.getName());
                    socket.getOutputStream().write(questionStr.getBytes());
                }
                Thread.sleep(10000);
            } catch (Exception ex) {
                Logger.getLogger(QuestionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
