package Game;

import javax.swing.*;
import java.awt.*;

class Ball extends JPanel {
    static int x, y, directionX, directionY;
    static Color color = Color.RED;

    Ball(){
        x = 9;
        y = 17;
        directionX = -1;
        directionY = -1;
    }

    void move(){
        x += directionX;
        y += directionY;
        if(x < 0){
            directionX *= -1;
        }
        if(x > GamePanel.WIDTH - 2){
            directionX *= -1;
        }
        if(y < 0){
            directionY *= -1;
        }
        if((y == 17)&&(x == Board.board[0] || x == Board.board[1] || x == Board.board[2] || x == Board.board[3] )){
            directionY *= -1;
        }
        if((y == 17)&&(x == Board.board[3] + 1 || x == Board.board[0] - 1)){
            directionY *= -1;
            directionX *= -1;
        }
        for(int i = 0; i < GamePanel.breaks.size(); i++){
            if((y == GamePanel.breaks.get(i).y + 1)&&(x == GamePanel.breaks.get(i).x )){
                directionY *= -1;
                GamePanel.breaks.remove(i);
                Game.score++;
                break;
            }
            if((y == GamePanel.breaks.get(i).y + 1)&&(x == GamePanel.breaks.get(GamePanel.breaks.size() - 1).x + 1 || x == GamePanel.breaks.get(0).x - 1)){
                directionY *= -1;
                directionX *= -1;
                GamePanel.breaks.remove(i);
                Game.score++;
                break;
            }
        }
    }
}