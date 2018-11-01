package Game;

import java.awt.*;

class Board {
    static int [] board = new int [4];
    static final int Y = 18;
    static int direction;
    static Color color = Color.BLACK;

    Board(){
        board[0] = 8;
        board[1] = 9;
        board[2] = 10;
        board[3] = 11;
    }

    void moveRight(){
        for(int i = 0 ; i < board.length; i++){
            if(board[3] < GamePanel.WIDTH - 1) board[i]++;
        }
    }
    void moveLeft(){
        for(int i = 0 ; i < board.length; i++){
            if(board[3] > 3)board[i]--;
        }
    }
}