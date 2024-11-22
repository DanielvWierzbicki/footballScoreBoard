package coding.challenge.match;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    private ScoreBoard scoreBoard;
    private final String HOME_TEAM = "Mexico";
    private final String INVALID_HOME_TEAM = "incorrect_value";
    private final String AWAY_TEAM = "Canada";

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    void testCreateScoreBoard() {
        assertNotNull(scoreBoard);
    }

    @Test
    void testStartMatch() {
        scoreBoard.startMatch(HOME_TEAM, AWAY_TEAM);

        int homeScore = scoreBoard.getMatches().get(0).getHomeScore();
        int awayScore = scoreBoard.getMatches().get(0).getHomeScore();

        assertEquals(1, scoreBoard.getMatches().size());
        assertEquals(0, homeScore);
        assertEquals(0, awayScore);
    }

    @Test
    void testUpdateScore() {
        scoreBoard.startMatch(HOME_TEAM, AWAY_TEAM);
        scoreBoard.updateScore(HOME_TEAM, AWAY_TEAM, 2, 1);

        var match = scoreBoard.getMatches().get(0);

        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }

    @Test
    void testFinishMatch() {
        scoreBoard.startMatch(HOME_TEAM, AWAY_TEAM);

        // After starting the match, there is new match created
        assertFalse(scoreBoard.getMatches().isEmpty());

        scoreBoard.finishMatch(HOME_TEAM, AWAY_TEAM);

        // After finishing the match, the match is removed
        assertTrue(scoreBoard.getMatches().isEmpty());
    }

    @Test
    void testSummarySorting() {
        scoreBoard.startMatch("Mexico", "Canada");
        scoreBoard.updateScore("Mexico", "Canada", 0, 5);

        scoreBoard.startMatch("Spain", "Brazil");
        scoreBoard.updateScore("Spain", "Brazil", 10, 2);

        scoreBoard.startMatch("Germany", "France");
        scoreBoard.updateScore("Germany", "France", 2, 2);

        scoreBoard.startMatch("Uruguay", "Italy");
        scoreBoard.updateScore("Uruguay", "Italy", 6, 6);

        scoreBoard.startMatch("Argentina", "Australia");
        scoreBoard.updateScore("Argentina", "Australia", 3, 1);

        List<Match> summary = scoreBoard.getSummary();

        assertEquals("Uruguay 6 - Italy 6", summary.get(0).toString());
        assertEquals("Spain 10 - Brazil 2", summary.get(1).toString());
        assertEquals("Mexico 0 - Canada 5", summary.get(2).toString());
        assertEquals("Argentina 3 - Australia 1", summary.get(3).toString());
        assertEquals("Germany 2 - France 2", summary.get(4).toString());
    }

    }

}
