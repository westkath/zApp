package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SummonerResultsController {

    @FXML private Pane summonerIcon;
    @FXML private TextField summonerName;
    @FXML private TextField summonerLevel;
    @FXML private Pane soloRankIcon;
    @FXML private TextField rankedSoloDuo;
    @FXML private TextField srWR;
    @FXML private Pane flexRankIcon;
    @FXML private TextField rankedFlex;
    @FXML private TextField flexWR;

    public void lightMode(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getScene().getStylesheets().remove(getClass().getClassLoader().getResource("results.css"));
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("lightResults.css")));
    }

    public void darkMode(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getScene().getStylesheets().remove(getClass().getClassLoader().getResource("lightResults.css"));
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("results.css")));
    }

    public void setSummonerIcon(int iconId) {
        String pathToIcon = accessSummonerIcon(iconId);
        ImageView icon = new ImageView(new Image("file:/" + pathToIcon));
        setSummonerIconProperties(icon);
        this.summonerIcon.getChildren().add(icon);
    }

    public void setSoloRankIcon(String rank) {
        String pathToIcon = "C:/Users/GA1/Desktop/PersonalProject/zApp/src/main/resources/rankedTierIcons/" + rank.toLowerCase() + ".png";
        ImageView icon = new ImageView(new Image("file:/" + pathToIcon));
        setIconProperties(icon);
        this.soloRankIcon.getChildren().add(icon);
    }

    public void setRankedSoloDuo(String soloRank) {
        this.rankedSoloDuo.setText("Solo: " + soloRank);
    }

    public void setSrWR(double soloWR) {
        this.srWR.setText("Solo WR: " + String.valueOf(soloWR) + "%");
    }

    public void setFlexRankIcon(String rank) {
        String pathToIcon = "C:/Users/GA1/Desktop/PersonalProject/zApp/src/main/resources/rankedTierIcons/" + rank.toLowerCase() + ".png";
        ImageView icon = new ImageView(new Image("file:/" + pathToIcon));
        setIconProperties(icon);
        this.flexRankIcon.getChildren().add(icon);
    }

    public void setRankedFlex(String flexRank) {
        this.rankedFlex.setText("Flex: " + flexRank);
    }

    public void setFlexWR(double flexWR) {
        this.flexWR.setText("Flex WR: " + String.valueOf(flexWR) + "%");
    }

    public void setSummonerName(String summonerName) {
        this.summonerName.setText("Summoner: " + summonerName);
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel.setText("Level: " + String.valueOf(summonerLevel));
    }

    public String accessSummonerIcon(int iconId) {
        String fileOutputPath = "C:/Users/GA1/Desktop/PersonalProject/zApp/src/main/resources/" + String.valueOf(iconId) + ".png";

        File icon = new File(fileOutputPath);

        if (icon.exists()) {
            return fileOutputPath;
        }

        try(InputStream in = new URL("http://ddragon.leagueoflegends.com/cdn/9.22.1/img/profileicon/" + String.valueOf(iconId) + ".png").openStream()){
            Files.copy(in, Paths.get(fileOutputPath));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return fileOutputPath;
    }

    public void setSummonerIconProperties(ImageView icon) {
        icon.setFitHeight(210.0);
        icon.setFitWidth(210.0);
        icon.setX(2);
        icon.setY(2);
    }

    public void setIconProperties(ImageView icon) {
        icon.setFitHeight(195.0);
        icon.setFitWidth(195.0);
        icon.setX(0);
        icon.setY(5);
    }

}
