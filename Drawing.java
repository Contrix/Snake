package snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Jirka
 */
public class Drawing {
    private final int px = 20;
    private final Game gm = new Game();
    private final int posunY = 100;
    private final int posunX = 20;

    public void draw(GraphicsContext gc, double width, double height){
        drawBackGround(gc);
        drawBod(gc);
        drawSnake(gc);
        drawPanel(gc);
    }
    
    public void drawBackGround(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, 540, 700);
              
        for (int i = 0; i < 25; i++){
            for (int j = 0; j < 25; j++){
                gc.setFill(Color.GREEN);
                gc.fillRect(i * px + posunX, j * px + posunY, px, px);
                gc.setFill(Color.LIGHTGREEN);
                gc.fillRect(i * px + posunX, j * px + posunY, px-1, px-1);
            }
        }
    }
    
    public void drawBod(GraphicsContext gc){
        gc.setFill(Color.AQUA);
        gc.fillRect(gm.getBod().getX() * px + posunX, gm.getBod().getY() * px + posunY, px, px);
    }
    
    public void drawSnake(GraphicsContext gc){
        gc.setFill(Color.YELLOW);
        for (MyPoint p : gm.getSnake()){
            gc.fillRect(p.getX() * px + posunX, p.getY() * px + posunY, px, px);
        }
        gc.setFill(Color.RED);
        gc.fillRect(gm.getSnake().get(0).getX() * px + posunX, gm.getSnake().get(0).getY() * px + posunY, px, px);
    }
    
    public void drawPanel(GraphicsContext gc){
        gc.setFill(Color.LIGHTGREEN);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gc.fillText(String.format("Level"), 75 + posunX, 25);
        gc.fillText(String.format("Čas"), 250 + posunX, 25);
        gc.fillText(String.format("Délka"), 425 + posunX, 25);
        
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        gc.fillText(String.format("%2d : %2d", gm.getTime()[1], gm.getTime()[0]), 250 + posunX, 75);
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        gc.fillText(String.format("%d", gm.getLevel()), 75 + posunX, 75);
        gc.fillText(String.format("%d", gm.getSnake().size()-4), 425 + posunX, 75);
        
        gc.setFont(Font.font("Verdana", 10));
        
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("© Jiří Hanák"), 530, 615);
        
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("v 1.0"), 10, 615);
    }
}
