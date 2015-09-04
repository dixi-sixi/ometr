package com.sigireu.ometr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by nod on 02.09.15.
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ometr");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);


        Pane root = new Pane();
        Button btn = new Button("button");
        btn.setText("button");
        btn.setTranslateX(100);
        btn.setTranslateY(50);
        btn.setPrefSize(100, 30);
        btn.setOnAction(event -> {
            System.out.println("OK");
        });
        Scene scene = new Scene(root);
        root.getChildren().addAll(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
