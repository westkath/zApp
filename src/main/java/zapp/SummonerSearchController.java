package zapp;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SummonerSearchController {

    private Scene resultsScene;

    public void setResultsScene(Scene resultsScene) {
        this.resultsScene = resultsScene;
    }

    public void openResultsScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(resultsScene);
    }

}
