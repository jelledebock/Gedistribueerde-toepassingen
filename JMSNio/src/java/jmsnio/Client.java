/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsnio;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelle
 */
public class Client implements Runnable{
    private Socket socket;
    private String name;
    private int points;
    private ClientServer clientServer;
    
    public Client(Socket socket, String name, int points, ClientServer clientServer) {
        this.socket = socket;
        this.name = name;
        this.points = points;
        this.clientServer = clientServer;
    }



    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void run() {
       while(true){
            try {
                BufferedReader input;
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line;  
                line = input.readLine();

                analyzeInput(line);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
       }    
    }

    private void analyzeInput(String line) {
        String action = line.split(" ")[0];
        System.out.println("Activity from "+socket.getPort());
        if(action.equals("QUIT")){
            System.out.println("Removing client "+getName()+" with "+getPoints()+" points.");
            clientServer.removeClient(this);
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(action.equals("ANSWER")){
            int questionId = Integer.parseInt(line.split(" ")[1]);
            String answer = line.split(" ")[2];
                
            System.out.println("Pushing anwer of question "+questionId+"(= "+answer+") to the queue.");
            //TODO: add the answer of the client to the queue
            clientServer.addAnswer(answer, questionId, this);
        }
    }
    
    
   
}
