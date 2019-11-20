package ui;

import javafx.application.Platform;
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

    private boolean isLight;

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

            if (isLight) {
                resultsScene.getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("lightResults.css")));
            } else {
                resultsScene.getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("results.css")));
            }

            SummonerResultsController controller = loader.getController();

            // Let's Make a new Summoner with the Region and Summoner Name
            SummonerResults summonerResults = new SummonerResults(summonerName.getText(), region.getValue().toString());
            if (summonerResults.isInvalid()) {
                showErrorMessage("Summoner not found!", "You have not entered a valid summoner.");
                Platform.exit(); // to adapt in future versions
                System.exit(0);
            } else {
                // Update to Show Summoner Details
                controller.setSummonerName(summonerResults.getSummonerName());
                controller.setSummonerIcon(summonerResults.getSummonerIcon());
                controller.setSummonerLevel(summonerResults.getSummonerLevel());

                if (summonerResults.isHasSolo()) {
                    controller.setSoloRankIcon(summonerResults.getSoloRankTier());
                    controller.setRankedSoloDuo(summonerResults.getRankedSoloDuo());
                    controller.setSrWR(summonerResults.getSrWR());
                }

                if (summonerResults.isHasFlex()) {
                    controller.setFlexRankIcon(summonerResults.getFlexRankTier());
                    controller.setRankedFlex(summonerResults.getRankedFlex());
                    controller.setFlexWR(summonerResults.getFlexWR());
                }

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(resultsScene);
            }

        }
    }

    public void lightMode(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getScene().getStylesheets().remove(getClass().getClassLoader().getResource("search.css"));
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("lightSearch.css")));
        isLight = true;
    }

    public void darkMode(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getScene().getStylesheets().remove(getClass().getClassLoader().getResource("lightSearch.css"));
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("search.css")));
        isLight = false;
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
