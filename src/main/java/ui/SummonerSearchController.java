package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SummonerSearchController {

    private Scene resultsScene;

    @FXML private TextField summonerName;
    @FXML private Button search;
    @FXML private ComboBox region;

    public void openResultsScene(ActionEvent event) throws IOException {
        Parent resultsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("SummonerResults.fxml")));
        Scene resultsScene = new Scene(resultsRoot, 600, 400);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(resultsScene);
    }

}
