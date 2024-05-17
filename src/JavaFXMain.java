import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class JavaFXMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Button btn = new Button("Test");
        Text text = new Text("Hello world");
        text.setVisible(false);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello world!");
                text.setVisible(!text.isVisible());
            }
        });

        HBox root = new HBox();

        root.getChildren().add(btn);
        root.getChildren().add((text));

        Scene scene = new Scene(root, 500,500);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}