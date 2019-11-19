package logic;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class SummonerResults {

    private String region; // kinda obsolete
    private String summonerName;
    private int summonerLevel;
    private String summonerIcon;
    private String rankedSoloDuo;
    private String soloRankIcon;
    private double srWR;
    private String rankedFlex;
    private String flexRankIcon;
    private double flexWR;
    private LeagueData leagueData;

    public SummonerResults(String summonerName, String region) {
        this.summonerName = summonerName;
        this.region = region;
        // Retrieve and Assign Appropriate Values
        // getSummonerData(); todo this later
        getLeagueData();
        this.rankedSoloDuo = leagueData.getRankedSoloDuo();
        this.srWR = leagueData.getSrWR();
        this.rankedFlex = leagueData.getRankedFlex();
        this.flexWR = leagueData.getFlexWR();
    }

    public void getLeagueData() {
        Orianna.setRiotAPIKey("RGAPI-1ca619e6-d887-40b9-988e-6542cf9e7d64");
        Orianna.setDefaultRegion(Region.NORTH_AMERICA);
        SummonerData data = new SummonerData(summonerName, region);
        Summoner summoner = data.getSummoner(); // todo fix the summonerdata class for this, ensure everything is set up correctly!
        this.leagueData = new LeagueData(summoner);
    }

    public String getSummonerName() {
        return this.summonerName;
    }

    public String getSummonerIcon() {
        return String.valueOf(getClass().getClassLoader().getResource("testIcon.png"));
    }

    public String toString(double val) {
        return String.valueOf(val);
    }

    public String toString(int val) {
        return String.valueOf(val);
    }

}
