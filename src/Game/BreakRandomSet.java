package Game;

import java.util.ArrayList;
import java.util.Random;

class BreakRandomSet {
    private int LEN = 10;

    private ArrayList<Break> set = new ArrayList<Break>();

    private int randomArray [] = new int[LEN];

    private Random random = new Random();

    static ArrayList<ArrayList<Break>> horizontalSet = new ArrayList<ArrayList<Break>>();

    BreakRandomSet(){
        horizontalSet.clear();
    }

    void makeRandomArray(){

        for(int i = 0; i < randomArray.length; i++){
            randomArray[i] = random.nextInt(20);
        }

    }
    ArrayList<Break> set(int y){
        for(int i = 0; i < randomArray.length; i++){
            Break break1 = new Break(randomArray[i], y);
            set.add(break1);
        }
        return set;
    }
    void move(){
        if((Ball.y == GamePanel.breaksY+2)&& Ball.directionY == -1) {
            horizontalSet.add(GamePanel.breaks);
            makeRandomArray();
            GamePanel.breaks = set(++GamePanel.breaksY);
        }
    }
}