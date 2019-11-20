package logic;

import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.core.league.LeagueEntry;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class LeagueData {

    private Summoner summoner;

    private String rankedSoloDuo;
    private String rankedSoloTier;
    private double srWR;

    private boolean hasSolo;
    private boolean hasFlex;

    private String rankedFlex;
    private String rankedFlexTier;
    private double flexWR;

    public LeagueData(Summoner summoner) {
        this.summoner = summoner;
        getRankedSoloData();
        getRankedFlexData();
    }

    public void getRankedSoloData() {
        LeagueEntry leaguePosition = summoner.getLeaguePosition(Queue.RANKED_SOLO);
        if (leaguePosition == null) {
            this.hasSolo = false;
        } else {
            this.rankedSoloDuo = leaguePosition.getTier().toString() + " " + leaguePosition.getDivision().toString();
            this.rankedSoloTier = leaguePosition.getTier().toString();
            this.srWR = Math.round(((double) leaguePosition.getWins() / ((double) leaguePosition.getWins() + (double) leaguePosition.getLosses())) * 100);
            this.hasSolo = true;
        }
    }

    public void getRankedFlexData() {
        LeagueEntry leaguePosition = summoner.getLeaguePosition(Queue.RANKED_FLEX);
        if (leaguePosition == null) {
            this.hasFlex = false;
        } else {
            this.rankedFlex = leaguePosition.getTier().toString() + " " + leaguePosition.getDivision().toString();
            this.rankedFlexTier = leaguePosition.getTier().toString();
            this.flexWR = Math.round(((double) leaguePosition.getWins() / ((double) leaguePosition.getWins() + (double) leaguePosition.getLosses())) * 100);
            this.hasFlex = true;
        }
    }

    public String getRankedSoloDuo() {
        return rankedSoloDuo;
    }

    public double getSrWR() {
        return srWR;
    }

    public double getFlexWR() {
        return flexWR;
    }

    public String getRankedSoloTier() {
        return rankedSoloTier;
    }

    public String getRankedFlexTier() {
        return rankedFlexTier;
    }

    public String getRankedFlex() {
        return rankedFlex;
    }

    public boolean getHasSolo() {
        return this.hasSolo;
    }

    public boolean getHasFlex() {
        return this.hasFlex;
    }

}
