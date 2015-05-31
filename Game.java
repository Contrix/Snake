package snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jirka
 */
public class Game {
    private static final ArrayList<MyPoint> snake = new ArrayList<>(Arrays.asList(new MyPoint(12,12), new MyPoint(12,13), new MyPoint(12,14), new MyPoint(12,15)));
    private int k = 0;//směr
    private MyPoint last = new MyPoint(0,0);
    private boolean gameOver = false;
    private static MyPoint bod = new MyPoint(10,5);
    private static int[] time = {0,0};
    private static int level = 1;
    Random random = new Random();
    
    
    public void next(){
        if (!gameOver){
            last = snake.get(snake.size()-1);
            if (snake.size()-1 >= 1){
                for (int i = snake.size()-1; i >= 1; i--){
                    snake.get(i).setPoint(snake.get(i-1));
                }            
            } 

            if (snake.get(0).getX() == bod.getX() && snake.get(0).getY() == bod.getY()){
                snake.add(new MyPoint(last.getX(),last.getY()));
                bod.setPoint(random.nextInt(25),random.nextInt(25));
            }
            switch(k){
                case 0://w
                    if (snake.get(0).getY() > 0)
                        snake.get(0).decY();
                    else
                        snake.get(0).setY(24);
                    break;
                case 1://s
                    if (snake.get(0).getY() < 24)
                        snake.get(0).incY();
                    else
                        snake.get(0).setY(0);
                    break;

                case 2://a
                    if (snake.get(0).getX() > 0)
                        snake.get(0).decX();
                    else
                        snake.get(0).setX(24);
                    break;
                case 3://d
                    if (snake.get(0).getX() < 24)
                        snake.get(0).incX();
                    else
                        snake.get(0).setX(0);
                    break;
            }
            for (int i = 1; i < snake.size()-1; i++){
                if (snake.get(i).getX() == snake.get(0).getX() && snake.get(i).getY() == snake.get(0).getY()){
                    gameOver = true;
                }
            }
        }
    }
    
    public void setKey(int k){
        this.k = k;
    }

    public ArrayList<MyPoint> getSnake(){
        return (snake);
    }
    
    public MyPoint getBod(){
        return(bod);
    }    
    
    public int[] getTime(){
        return(time);
    }
    
    public void setTime(){
        time[0] ++;
        if(time[0] == 60)
        {
            time[0] = 0;
            time[1] ++;
        }
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    
    public int getLevel(){
        return (level);
    }
    
    public boolean getGameOver(){
        return (gameOver);
    }
}
