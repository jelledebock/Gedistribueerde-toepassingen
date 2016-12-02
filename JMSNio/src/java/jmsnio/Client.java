/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsnio;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelle
 */
public class Client{
    private SocketChannel socket;
    private String name;
    private int points;
    private ClientServer clientServer;
    
    public Client(SocketChannel socket, String name, int points, ClientServer clientServer) {
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
   
}
