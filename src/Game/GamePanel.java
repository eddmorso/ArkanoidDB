package Game;

import User.LogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCALE = 30;
    static final int WIDTH = 20;
    static final int HEIGHT = 20;

    private Board board = new Board();

    private Ball ball = new Ball();

    static ArrayList<Break> breaks;

    static int breaksY;

    private BreakRandomSet breakRandomSet = new BreakRandomSet();

    Timer timer = new Timer(150,this);

    GamePanel(){
        breaksY = 0;
        breakRandomSet.makeRandomArray();
        breaks = breakRandomSet.set(breaksY);
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint(Graphics graphics) {

        //Color of background
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, SCALE * WIDTH, SCALE * HEIGHT);

        //Setting rows and columns
       /* graphics.setColor(Color.yellow);
        for (int i = 0; i < HEIGHT * SCALE; i += SCALE) {
            graphics.drawLine(i, 0, i, WIDTH * SCALE);
        }

        for (int i = 0; i < WIDTH * SCALE; i += SCALE) {
            graphics.drawLine(0, i, HEIGHT * SCALE, i);
        }
*/
        //Setting board
        graphics.setColor(Board.color);
        int index = 0;
        while (index < 4) {
            graphics.fillRect(Board.board[index] * SCALE + 1, Board.Y * SCALE + 1, SCALE - 1, SCALE / 2 - 1);
            index++;
        }

        //Setting ball
        graphics.setColor(Ball.color);
        graphics.fillOval(Ball.x * SCALE, Ball.y * SCALE, SCALE - 1, SCALE - 1);

        //Setting breaks
        graphics.setColor(Break.color);
        for(int i = 0; i < BreakRandomSet.horizontalSet.size(); i++) {
            for (int j = 0; j < BreakRandomSet.horizontalSet.get(i).size(); j++) {
                graphics.fillRect(BreakRandomSet.horizontalSet.get(i).get(j).x * SCALE, BreakRandomSet.horizontalSet.get(i).get(j).y * SCALE, SCALE, SCALE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        ball.move();
        breakRandomSet.move();
        repaint();
        if(Ball.y > 18){
            Game.jFrame.dispose();
            timer.stop();
            new GameOverDialog();
        }
        if(breaksY == Board.Y - 1){
            Game.jFrame.dispose();
            timer.stop();
            new GameOverDialog();
        }
    }

    private class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent) {
            int key = keyEvent.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                Board.direction = 0;
                board.moveRight();
                repaint();
            }
            if (key == KeyEvent.VK_LEFT) {
                Board.direction = 2;
                board.moveLeft();
                repaint();
            }
            if(key == KeyEvent.VK_ESCAPE){
                timer.stop();
                Game.jFrame.dispose();
                new LogIn();
            }
        }
    }
}