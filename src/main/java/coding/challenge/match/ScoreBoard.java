package coding.challenge.match;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScoreBoard {

    private final List<Match> matches;

    public ScoreBoard() {
        this.matches = new ArrayList<>();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        var match = matches.stream()
                .filter(mch -> mch.getHomeTeam().equals(homeTeam) && mch.getAwayTeam().equals(awayTeam))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Match not found"));

        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        matches.removeIf(mch -> mch.getHomeTeam().equals(homeTeam) && mch.getAwayTeam().equals(awayTeam));
    }
}

