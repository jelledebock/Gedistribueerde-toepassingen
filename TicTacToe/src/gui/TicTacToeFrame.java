/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vongenae
 */
public class TicTacToeFrame extends JFrame {
    
    private final JLabel messageLabel = new JLabel("");
    
    private static char PlayerMark;
    private static char OpponentMark;
    private Color PlayerColor;
    private Color OpponentColor;
    private Square[] board = new Square[9];
    private Square currentSquare;
    private int currentPosition;
    private final Font LabelFont = new Font("Arial", Font.BOLD, 16);
    
    
    public TicTacToeFrame() throws HeadlessException {
        super("Tic Tac Toe");
        // Layout GUI
        messageLabel.setBackground(Color.lightGray);
        getContentPane().add(messageLabel, "South");
        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.black);
        boardPanel.setLayout(new GridLayout(3, 3, 2, 2));
        for (int i = 0; i < board.length; i++) {
            final int j = i;
            board[i] = new Square();
            board[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // current square is the square clicked by the mouse
                    currentSquare = board[j];
                    currentPosition = j;
                    // notify ...
                }
            });
            boardPanel.add(board[i]);
        }
        getContentPane().add(boardPanel, "Center");
    }
    
    protected void setMark(char mark) {
        PlayerMark = mark == 'X' ? 'X' : 'O';
        PlayerColor = mark == 'X' ? Color.RED : Color.BLUE;
        OpponentMark = mark == 'X' ? 'O' : 'X';
        OpponentColor = mark == 'X' ? Color.BLUE : Color.RED;
        setTitle("Tic Tac Toe - Player " + mark);
    }
    
    protected void validMove() {
        messageLabel.setText("Valid move --> PLEASE WAIT");
        currentSquare.label.setFont(LabelFont);
        currentSquare.label.setForeground(PlayerColor);
        currentSquare.label.setText(Character.toString(PlayerMark));
    }
    
    protected void opponentMoved(int loc) {
        messageLabel.setText("Opponent moved --> YOUR TURN");
        board[loc].label.setFont(LabelFont);
        board[loc].label.setForeground(OpponentColor);
        board[loc].label.setText(Character.toString(OpponentMark));
    }
    
    protected void bericht(String tekst) {
        messageLabel.setText(tekst);
    }
    
    protected int getPosition() {
        return currentPosition;
    }
    
  

    /**
     * Graphical square in the client window. Each square is a white panel
     * containing an X or O.
     */
    class Square extends JPanel {
        
        JLabel label = new JLabel();
        
        public Square() {
            setBackground(Color.WHITE);
            add(label);
        }
    }
}
