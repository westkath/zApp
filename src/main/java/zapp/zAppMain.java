package zapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class zAppMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("zStats | Summoner Search");

        // Summoner Search Scene
        FXMLLoader summonerSearchLoader = new FXMLLoader(getClass().getResource("ui.SummonerSearch.fxml"));
        Parent summonerSearch = summonerSearchLoader.load();
        Scene SummonerSearchScene = new Scene(summonerSearch, 600, 400);

        // Summoner Results Scene
        FXMLLoader summonerResultsLoader = new FXMLLoader(getClass().getResource("ui.SummonerResults.fxml"));
        Parent summonerResults = summonerResultsLoader.load();
        Scene SummonerResultsScene = new Scene(summonerResults, 600, 400);

        // Summoner Search Controller
        SummonerSearchController searchController = (SummonerSearchController) summonerSearchLoader.getController();
        searchController.setResultsScene(SummonerResultsScene);

        // Summoner Results Controller
        SummonerResultsController resultsController = (SummonerResultsController) summonerResultsLoader.getController();
        resultsController.setSearchScene(SummonerSearchScene);

        // Initial Launch
        primaryStage.setScene(SummonerSearchScene);
        primaryStage.setTitle("zStats | Application");
        primaryStage.show();
    }

}
