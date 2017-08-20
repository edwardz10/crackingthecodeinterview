package programming.interviews.exposed.junit.highscore;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GameTestWithStub {

	private static class StubHighScoreService
		implements HighScoreService {

		@Override
		public List<String> getTopFivePlayers() {
			return Arrays.asList(
				"Alice",
				"Bob",
				"Charlie",
				"Dave",
				"Elizabeth"
			);
		}

		@Override
		public boolean saveHighScore(int score, String playerName) {
			throw new UnsupportedOperationException("saveHighScore not implemented for this test");
		}
		
	}

	@Test
	public void highScoreDisplay() {
		final String expectedPlayerList =
				"1. Alice\n" +
						"2. Bob\n" +
						"3. Charlie\n" +
						"4. Dave\n" +
						"5. Elizabeth\n";

		final HighScoreService stubbedHighScoreService = 
				new StubHighScoreService();
		final Game gameUnderTest = new Game(stubbedHighScoreService);
		assertEquals(gameUnderTest.displayHighScores(), expectedPlayerList);
	}
}
