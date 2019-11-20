package zapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

public class zAppMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent searchRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("SummonerSearchExpanded.fxml")));
        Scene searchScene = new Scene(searchRoot, 800, 600);
        searchScene.getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("search.css")));

        primaryStage.setScene(searchScene);
        primaryStage.setTitle("zStats | Application");
        primaryStage.show();
    }

}
