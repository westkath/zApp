package logic;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.io.IOException;
import java.util.Properties;

public class SummonerResults {

    private String region; // kinda obsolete
    private String summonerName;
    private int summonerLevel;
    private int summonerIcon;
    private String rankedSoloDuo;
    private String soloRankTier;
    private double srWR;
    private String rankedFlex;
    private String flexRankTier;
    private double flexWR;
    private SummonerData summonerData;
    private LeagueData leagueData;
    private boolean hasSolo;
    private boolean hasFlex;
    private boolean invalid;

    public SummonerResults(String summonerName, String region) throws IOException {
        this.summonerName = summonerName;
        this.region = region;
        getLeagueData();
        if (invalid) {
            this.invalid = true;
        } else {
            this.invalid = false;
            this.summonerIcon = summonerData.getIconId();
            this.summonerLevel = summonerData.getSummonerLevel();
            this.rankedSoloDuo = leagueData.getRankedSoloDuo();
            this.soloRankTier = leagueData.getRankedSoloTier();
            this.srWR = leagueData.getSrWR();
            this.rankedFlex = leagueData.getRankedFlex();
            this.flexRankTier = leagueData.getRankedFlexTier();
            this.flexWR = leagueData.getFlexWR();
            this.hasSolo = leagueData.getHasSolo();
            this.hasFlex = leagueData.getHasFlex();
        }
    }

    public void getLeagueData() {
        String api_key = getAPIKey();
        Orianna.setRiotAPIKey(api_key);
        Orianna.setDefaultRegion(Region.EUROPE_WEST);
        SummonerData data = new SummonerData(summonerName, region);
        if (data.getInvalid()) {
            this.invalid = true;
        } else {
            this.invalid = false;
            this.summonerData = data;
            Summoner summoner = data.getSummoner();
            this.leagueData = new LeagueData(summoner);
        }
    }

    public String getSummonerName() {
        return this.summonerName;
    }

    public int getSummonerIcon() {
        return this.summonerIcon;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public String getRankedSoloDuo() {
        return rankedSoloDuo;
    }

    public String getSoloRankTier() {
        return soloRankTier;
    }

    public double getSrWR() {
        return srWR;
    }

    public String getRankedFlex() {
        return rankedFlex;
    }

    public String getFlexRankTier() {
        return flexRankTier;
    }

    public double getFlexWR() {
        return flexWR;
    }

    public boolean isHasSolo() {
        return hasSolo;
    }

    public boolean isHasFlex() {
        return hasFlex;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public String getAPIKey() {
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            return prop.getProperty("api_key");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
