/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsnio;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jelle
 */
class QuestionManager extends TimerTask{
    private Map<Client, SocketChannel> clients;
    private Selector selector;
    private Quiz quiz;


    QuestionManager() throws Exception {
        clients = new HashMap<>();
        quiz = new Quiz();
    }
    
    public void setSelector(Selector selector){
        this.selector = selector;
    }
    
    public void addClientToSubscriberList(Client client, SocketChannel sock){
        clients.put(client, sock);
    }

    @Override
    public void run() {
            //Get the question
            try {
                
                Question question = quiz.getQuestion();
                String questionStr="[id="+question.getId()+"]"+question.getQuestion()+"\n";
                System.out.println("Trying to send "+questionStr);
                ByteBuffer writeBuffer = ByteBuffer.allocateDirect(4096);
                // fills the buffer from the given string
                // and prepares it for a channel write
                writeBuffer.clear();
                writeBuffer.put(questionStr.getBytes());
                writeBuffer.putChar('\n');
                writeBuffer.flip();
                clients.entrySet().stream().map((entry) -> {
                    long nbytes = 0;
                    long toWrite = writeBuffer.remaining();
                    // loop on the channel.write() call since it will not necessarily
                    // write all bytes in one shot
                    try {
                        while (nbytes != toWrite) {
                            nbytes += entry.getValue().write(writeBuffer);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(QuestionManager.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    return entry;                    
                }).forEachOrdered((_item) -> {
                    // get ready for another write if needed
                    writeBuffer.rewind();
                });
            }catch(Exception e){
                  Logger.getLogger(QuestionManager.class
                                .getName()).log(Level.SEVERE, null, e);
            }
    }
}
