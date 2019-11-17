package logic;

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

    public SummonerResults(String summonerName, String region) {
        this.summonerName = summonerName;
        this.region = region;
        // other properties here that will use other logic classes
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
