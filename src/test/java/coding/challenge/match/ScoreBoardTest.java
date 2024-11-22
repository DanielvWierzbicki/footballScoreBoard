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

}
