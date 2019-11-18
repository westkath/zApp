package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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

    public void setSummonerIcon(String pathToIcon) {
        ImageView icon = new ImageView(new Image(pathToIcon));
        setIconProperties(icon);
        this.summonerIcon.getChildren().add(icon);
    }

    public void setSummonerName(String summonerName) {
        this.summonerName.setText(summonerName);
        this.summonerName.setEditable(false);
    }

    public void setSummonerLevel(String summonerLevel) {
        this.summonerLevel.setText(summonerLevel);
    }

    public void setIconProperties(ImageView icon) {
        icon.setFitHeight(210.0);
        icon.setFitWidth(210.0);
        icon.setX(2);
        icon.setY(2);
    }

}
