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
                .filter(mat -> mat.getHomeTeam().equals(homeTeam) && mat.getAwayTeam().equals(awayTeam))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Match not found"));

        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }
}

