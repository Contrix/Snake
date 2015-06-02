package snake;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jirka
 */
public class Main extends Application {
    
    private final Drawing drw = new Drawing();
    private final Game gm = new Game();
    
    @Override
    public void start(Stage primaryStage) {
        //Základní nastavení
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 620);
        primaryStage.setTitle("Snake");
        Canvas canvas = new Canvas(scene.getWidth(), scene.getHeight());
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        drw.draw(gc, canvas.getWidth(), canvas.getHeight());
        
        //nastavení timeru
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent event) -> {
            if (!gm.getGameOver()){
                gm.setTime();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        
        Timeline timer5 = new Timeline(new KeyFrame(Duration.millis(30), (ActionEvent event) -> {
            if (gm.getSnake().size() >= 24){
                gm.next();
                drw.draw(gc, canvas.getWidth(), canvas.getHeight());
                gm.setLevel(5);
            }
        }));
        timer5.setCycleCount(Timeline.INDEFINITE);
        timer5.play();
        
        Timeline timer4 = new Timeline(new KeyFrame(Duration.millis(50), (ActionEvent event) -> {
            if (gm.getSnake().size() < 24 && gm.getSnake().size() >= 19){
                gm.next();
                drw.draw(gc, canvas.getWidth(), canvas.getHeight());
                gm.setLevel(4);
            }
        }));
        timer4.setCycleCount(Timeline.INDEFINITE);
        timer4.play();
        
        Timeline timer3 = new Timeline(new KeyFrame(Duration.millis(100), (ActionEvent event) -> {
            if (gm.getSnake().size() < 19 && gm.getSnake().size() >= 14){
                gm.next();
                drw.draw(gc, canvas.getWidth(), canvas.getHeight());
                gm.setLevel(3);
            }
        }));
        timer3.setCycleCount(Timeline.INDEFINITE);
        timer3.play();
        
        Timeline timer2 = new Timeline(new KeyFrame(Duration.millis(150), (ActionEvent event) -> {
            if (gm.getSnake().size() < 14 && gm.getSnake().size() >= 9){
                gm.next();
                drw.draw(gc, canvas.getWidth(), canvas.getHeight());
                gm.setLevel(2);
            }

        }));
        timer2.setCycleCount(Timeline.INDEFINITE);
        timer2.play();

        Timeline timer1 = new Timeline(new KeyFrame(Duration.millis(200), (ActionEvent event) -> {
            if (gm.getSnake().size() < 9){
                gm.next();
                drw.draw(gc, canvas.getWidth(), canvas.getHeight());
                gm.setLevel(1);
            }
        }));
        timer1.setCycleCount(Timeline.INDEFINITE);
        timer1.play();
        
        //čtení kláves
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            switch (e.getCode()) {
                case W:
                    gm.setKey(0);
                    break;
                case S:
                    gm.setKey(1);
                    break;
                case A:
                    gm.setKey(2);
                    break;
                case D:
                    gm.setKey(3);
                    break;
                    
                case NUMPAD8:
                    gm.setKey(0);
                    break;
                case NUMPAD2:
                    gm.setKey(1);
                    break;
                case NUMPAD4:
                    gm.setKey(2);
                    break;
                case NUMPAD6:
                    gm.setKey(3);
                    break;
                    
                case UP:
                    gm.setKey(0);
                    break;
                case DOWN:
                    gm.setKey(1);
                    break;
                case LEFT:
                    gm.setKey(2);
                    break;
                case RIGHT:
                    gm.setKey(3);
                    break;
                case F5:
                    gm.reset();
                    break;
                case ESCAPE:
                    primaryStage.close();
                    break;
                default:
                    break;
            }
        });
        
        //vykrslení plochy
        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
