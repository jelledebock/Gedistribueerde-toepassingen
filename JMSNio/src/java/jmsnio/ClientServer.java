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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jelle
 */
public class ClientServer implements Runnable{
    private static int PORT = 8888;
    private Map<Socket, Client> clients = new HashMap<>();
    private ServerSocket serverSocket;
    private QuestionManager questionManager;
    private ExecutorService clientPool = Executors.newCachedThreadPool();

    
    public ClientServer(QuestionManager qm) throws IOException {
         serverSocket = new ServerSocket(PORT);
         serverSocket.accept();
         questionManager = qm;
    }

    @Override
    protected void finalize() throws Throwable {
        serverSocket.close();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
        
    @Override
    public void run() {
        System.out.println("Accepting connections on "+serverSocket.getInetAddress().getCanonicalHostName());
        while(true){
            try {
                Socket socket = serverSocket.accept();
                
                BufferedReader input;
                input = new BufferedReader(new InputStreamReader(new DataInputStream(socket.getInputStream())));
                
                String line = input.readLine();                  
                analyzeInput(line,socket);
                
            } catch (IOException ex) {
                Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    private void analyzeInput(String line, Socket client) {
        String action = line.split(" ")[0];
        if(clients.get(client)==null && action.equals("REGISTER")){
            String clientname = line.split(" ")[1];
            clients.put(client, new Client(client, clientname, 0, this));
            System.out.println("Added a new client "+clientname);
            //Register client for questions
            questionManager.addClientToSubscriberList(clients.get(client),client);
            clientPool.execute(clients.get(client));
            String reply ="REGISTERED OK\n";
            try {
                client.getOutputStream().write(reply.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }

    void removeClient(Client client) {
        clients.remove(client);
    }

    void addAnswer(String answer, int questionId, Client client) {
        //TODO push answer to queue
        System.out.println("Client "+client.getName()+" ansered question "+questionId+" with answer\n "+answer);
    }
    
}
