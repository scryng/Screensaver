import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import javafx.scene.control.Button;

import java.awt.*;
import java.util.Random;

public class JavaFXMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Group root = new Group();
        Scene scene = new Scene(root, 500,500);
        scene.setFill(Color.BLACK);

        primaryStage.setScene(scene);

        // Elementos
        Rectangle r1 = new Rectangle();
        r1.setX(10);
        r1.setY(10);
        r1.setHeight(100);
        r1.setWidth(100);
        r1.setFill(Color.CYAN);
        root.getChildren().add(r1);

        final long startNanoTimer = System.nanoTime();

        new AnimationTimer(){
            double speedX = 10;
            double speedY = 10;
            Random color = new Random();
            @Override
            public void handle(long currentNanoTime) {
                double timer = (currentNanoTime - startNanoTimer) / 10000000000.0;
                // ANIMATION

                if (r1.getX() > scene.getWidth() - r1.getWidth() || r1.getX()<0) {
                    speedX *= -1;
                    r1.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256), 1.0));
                }

                if (r1.getY() > scene.getHeight() - r1.getHeight() || r1.getY()<0) {
                    speedY *= -1;
                    r1.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256), 1.0));
                }

                r1.setX(r1.getX()+speedX); // Movimentação
                r1.setY(r1.getY()+speedY); // Movimentação

                // ANIMATION
            }
        }.start();

        primaryStage.show();
    }
}