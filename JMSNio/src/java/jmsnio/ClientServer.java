/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author jelle
 */
public class ClientServer implements Runnable{
    private static int PORT = 8888;
    private Map<SocketChannel, Client> clients = new HashMap<>();
    private QuestionManager questionManager;
    private ServerSocketChannel socketChannel;
    private Selector selector;
    private ByteBuffer readBuffer;
    private Timer timer;
    
    public ClientServer(QuestionManager qm) throws IOException {
         readBuffer = ByteBuffer.allocate(4096);
         selector = initSelector();
         questionManager = qm;
         timer = new Timer();
    }
    
        
    @Override
    public void run() {
        try {
            System.out.println("Accepting connections on "+socketChannel.getLocalAddress().toString());
            questionManager.setSelector(selector);
            timer.scheduleAtFixedRate(questionManager, 0, 10000);
            while(true){
                    this.selector.select(); //wait for an event

                    // Iterate over the set of keys for which events are available
                    Iterator selectedKeys = this.selector.selectedKeys().iterator();
                    while (selectedKeys.hasNext()) {
                      SelectionKey key = (SelectionKey) selectedKeys.next();
                      selectedKeys.remove();

                      if (!key.isValid()) {
                        continue;
                      }

                      // Check what event is available and deal with it
                      if (key.isAcceptable()) {
                        this.accept(key);
                      }
                      if (key.isReadable()){
                          this.read(key);
                      }
                    }
            }
         } catch (IOException ex) {
                Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }

    void removeClient(Client client) {
        clients.remove(client);
    }

    void addAnswer(String answer, int questionId, Client client) {
        //TODO push answer to queue
        System.out.println("Client "+client.getName()+" ansered question "+questionId+" with answer\n "+answer);
    }

    private Selector initSelector() throws IOException {
        Selector socketSeletor = SelectorProvider.provider().openSelector();
        this.socketChannel=ServerSocketChannel.open();
        this.socketChannel.configureBlocking(false);
        
        InetSocketAddress inetAddr = new InetSocketAddress(PORT);
        this.socketChannel.socket().bind(inetAddr);
        
        this.socketChannel.register(socketSeletor, SelectionKey.OP_ACCEPT);
        
        return socketSeletor;
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel)key.channel();
        
        //Accept it
        SocketChannel sockChannel = channel.accept();
        Socket socket = sockChannel.socket();
        sockChannel.configureBlocking(false);
        
        sockChannel.register(this.selector, SelectionKey.OP_READ);
        write(sockChannel, "Welcome to the quiz server. Please register your name.\n");
    }

    private void read(SelectionKey key) throws IOException{
        SocketChannel socketChannel = (SocketChannel) key.channel();

        // Clear out our read buffer so it's ready for new data
        this.readBuffer.clear();

        // Attempt to read off the channel
        int numRead;
        try {
            numRead = socketChannel.read(this.readBuffer);
          
            readBuffer.flip();

            CharsetDecoder test = Charset.forName("UTF-8").newDecoder();
            String input = test.decode(readBuffer).toString();
            analyzeInput(key, input);
        } catch (IOException e) {
          // The remote forcibly closed the connection, cancel
          // the selection key and close the channel.
          key.cancel();
          socketChannel.close();
          return;
        }

        if (numRead == -1) {
          // Remote entity shut the socket down cleanly. Do the
          // same from our end and cancel the channel.
          key.channel().close();
          key.cancel();
          return;
        }
        
    }

    private void analyzeInput(SelectionKey key, String input) throws IOException {
        SocketChannel socketChannel = (SocketChannel)key.channel();
        input = input.trim();
        // TODO schooner?
        if (input.matches("REGISTER .*")) {
            Pattern pattern = Pattern.compile("REGISTER (.*)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(1);
                clients.put(socketChannel, new Client(socketChannel, name, 0, this));
                System.out.println(">> Registered: " + name);
                questionManager.addClientToSubscriberList(clients.get(socketChannel), socketChannel);
            }
        } else if (input.equals("QUIT")) {
            System.out.println("Disconnecting " + socketChannel);
            key.cancel();
            socketChannel.close();
        } else {
            String error = String.format("Unknown command: '%s'\n", input);
            System.out.println(error);
        }
    }
    
     private void write(SocketChannel client, String text) throws IOException {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        this.readBuffer.clear();
        this.readBuffer.put(bytes);
        this.readBuffer.flip();
        while (this.readBuffer.hasRemaining()) {
            client.write(readBuffer);
        }
    }
    
}
