package logic;

import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.core.league.LeagueEntry;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class LeagueData {

    private Summoner summoner;

    private String rankedSoloDuo;
    private double srWR;

    private String rankedFlex;
    private double flexWR;

    public LeagueData(Summoner summoner) {
        this.summoner = summoner;
        getRankedSoloData();
        getRankedFlexData();
    }

    public void getRankedSoloData() {
        LeagueEntry leaguePosition = summoner.getLeaguePosition(Queue.RANKED_SOLO);
        this.rankedSoloDuo = leaguePosition.getDivision().toString() + leaguePosition.getTier().toString();
        this.srWR = leaguePosition.getWins() / (leaguePosition.getWins() + leaguePosition.getLosses());
    }

    public void getRankedFlexData() {
        LeagueEntry leaguePosition = summoner.getLeaguePosition(Queue.RANKED_FLEX);
        this.rankedFlex = leaguePosition.getDivision().toString() + leaguePosition.getTier().toString();
        this.flexWR = leaguePosition.getWins() / (leaguePosition.getWins() + leaguePosition.getLosses());
    }

    public String getRankedSoloDuo() {
        return rankedSoloDuo;
    }

    public void setRankedSoloDuo(String rankedSoloDuo) {
        this.rankedSoloDuo = rankedSoloDuo;
    }

    public double getSrWR() {
        return srWR;
    }

    public void setSrWR(double srWR) {
        this.srWR = srWR;
    }

    public void setRankedFlex(String rankedFlex) {
        this.rankedFlex = rankedFlex;
    }

    public double getFlexWR() {
        return flexWR;
    }

    public void setFlexWR(double flexWR) {
        this.flexWR = flexWR;
    }

    public String getRankedFlex() {
        return rankedFlex;
    }

}
