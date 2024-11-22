package coding.challenge.match;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ScoreBoard {

    private final List<Match> matches;

    public ScoreBoard() {
        this.matches = new ArrayList<>();
    }

    /**
     * Creates a new match with two opponent teams
     *
     * @param homeTeam the home team
     * @param awayTeam the away team
     */
    public void startMatch(String homeTeam, String awayTeam) {
        if (homeTeam == null || awayTeam == null || homeTeam.isEmpty() || awayTeam.isEmpty()) {
            throw new IllegalArgumentException("Team names cannot be null or empty");
        }
        matches.add(new Match(homeTeam, awayTeam));
    }

    /**
     * Updates the score for both teams
     *
     * @param homeTeam the home team
     * @param awayTeam the away team
     * @param homeScore the home score
     * @param awayScore the away score
     */
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Scores must have positive values");
        }

        var match = matches.stream()
                .filter(mch -> mch.getHomeTeam().equals(homeTeam) && mch.getAwayTeam().equals(awayTeam))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Match not found"));

        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }

    /**
     * Removes the match after the finish part
     *
     * @param homeTeam the home team
     * @param awayTeam the away team
     */
    public void finishMatch(String homeTeam, String awayTeam) {
        matches.removeIf(mch -> mch.getHomeTeam().equals(homeTeam) && mch.getAwayTeam().equals(awayTeam));
    }

    /**
     * Sorts the list by following criteria: Those matches with the same total score
     * will be returned ordered by the most recently added to the system
     *
     * @return the sorted matches
     */
    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::getTotalScore).reversed()
                        .thenComparing(match -> matches.size() - matches.indexOf(match)))
                .collect(Collectors.toList());
    }
}

