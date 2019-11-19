package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.LeagueData;
import logic.SummonerResults;

import java.io.IOException;
import java.util.Objects;

public class SummonerSearchController {

    @FXML private TextField summonerName;
    @FXML private ComboBox region;

    // New Method w/ Changes won't run till name changed
    public void openResultsScene(ActionEvent event) throws IOException {
        // Check Region + Summoner has been Entered
        if (summonerName.getText() == null || region.getValue() == null) {
            showErrorMessage("NullPointerException", "Must enter both summoner name and region!");
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("SummonerResultsExpanded.fxml")));

            Parent resultsRoot = loader.load();
            Scene resultsScene = new Scene(resultsRoot, 800, 600);

            SummonerResultsController controller = loader.getController();

            // Let's Make a new Summoner with the Region and Summoner Name
            SummonerResults summonerResults = new SummonerResults(summonerName.getText(), region.getValue().toString());
            LeagueData leagueData = summonerResults.getLeagueData();

            // Update to Show Summoner Details
            controller.setSummonerName(summonerResults.getSummonerName());
            controller.setSummonerIcon(summonerResults.getSummonerIcon());


            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(resultsScene);
        }
    }

    public void showErrorMessage(String error, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!");
        alert.setHeaderText(error);
        alert.setContentText(message);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

}
