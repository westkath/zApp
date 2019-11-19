package logic;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class SummonerData {

    private Summoner summoner;

    public SummonerData(String summonerName, String region) {
        if (region.equals("EUW")) {
            this.summoner = Summoner.named(summonerName).withRegion(Region.EUROPE_WEST).get();
        }
        this.summoner = Summoner.named(summonerName).withRegion(Region.EUROPE_WEST).get(); // redundant for now
    }

    public Summoner getSummoner() {
        return this.summoner;
    }

}
