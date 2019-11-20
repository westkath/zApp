package logic;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class SummonerData {

    private Summoner summoner;
    private int summonerLevel;
    private int iconId;
    private boolean invalid;

    public SummonerData(String summonerName, String region) {
        if (region.equals("EUW")) {
            this.summoner = Summoner.named(summonerName).withRegion(Region.EUROPE_WEST).get(); // redundant for now
            if (summoner.exists()) {
                this.invalid = false;
                this.summonerLevel = summoner.getLevel();
                this.iconId = summoner.getProfileIcon().getId();
            } else {
                this.invalid = true;
            }
        }
        this.summoner = Summoner.named(summonerName).withRegion(Region.EUROPE_WEST).get(); // redundant for now
        if (summoner.exists()) {
            this.invalid = false;
            this.summonerLevel = summoner.getLevel();
            this.iconId = summoner.getProfileIcon().getId();
        } else {
            this.invalid = true;
        }
    }

    public Summoner getSummoner() {
        return this.summoner;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public int getIconId() {
        return iconId;
    }

    public boolean getInvalid() {
        return invalid;
    }

}
