package zapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class zAppMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent searchRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("SummonerSearch.fxml")));
        Scene searchScene = new Scene(searchRoot, 600, 400);

        primaryStage.setScene(searchScene);
        primaryStage.setTitle("zStats | Application");
        primaryStage.show();
    }

}
