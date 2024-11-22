package coding.challenge.match;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ScoreBoardTest {

    @Test
    void testCreateScoreBoard() {
        var scoreBoard = new ScoreBoard();
        assertNotNull(scoreBoard);
    }

    @Test
    void testStartMatch() {
        var scoreBoard = new ScoreBoard();
        scoreBoard.startMatch("Team A", "Team B");
        assertEquals(1, scoreBoard.getMatches().size());
    }

    @Test
    void testUpdateScore() {
        var scoreBoard = new ScoreBoard();
        scoreBoard.startMatch("Team A", "Team B");
        scoreBoard.updateScore("Team A", "Team B", 2, 1);

        var match = scoreBoard.getMatches().get(0);
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }
}
