package zapp;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SummonerResultsController {

    private Scene searchScene;

    public void setSearchScene(Scene searchScene) {
        this.searchScene = searchScene;
    }

    public void openSearchScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(searchScene);
    }

}
