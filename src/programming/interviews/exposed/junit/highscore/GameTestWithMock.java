package programming.interviews.exposed.junit.highscore;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTestWithMock {
	private final Game gameUnderTest;
	private final HighScoreService mockHighScoreService;

	public GameTestWithMock() {
		final List<String> firstHighScoreList = Arrays.asList(
			"Alice",
			"Bob",
			"Charlie",
			"Dave",
			"Elizabeth");

		final List<String> secondHighScoreList = Arrays.asList(
			"Fred",
			"Georgia",
			"Helen",
			"Ian",
			"Jane");

		this.mockHighScoreService = mock(HighScoreService.class);

		Mockito.when(mockHighScoreService.getTopFivePlayers())
			.thenReturn(firstHighScoreList)
			.thenReturn(secondHighScoreList);

		this.gameUnderTest = new Game(mockHighScoreService);
	}

	@Test
	public void highScoreDisplay() {
		final String firstExpectedPlayerList =
				"1. Alice\n" +
						"2. Bob\n" +
						"3. Charlie\n" +
						"4. Dave\n" +
						"5. Elizabeth\n";

		final String secondExpectedPlayerList =
				"1. Fred\n" +
						"2. Georgia\n" +
						"3. Helen\n" +
						"4. Ian\n" +
						"5. Jane\n";

		final String firstCall = gameUnderTest.displayHighScores();
		final String secondCall = gameUnderTest.displayHighScores();

		assertEquals(firstExpectedPlayerList, firstCall);
		assertEquals(secondExpectedPlayerList, secondCall);

		verify(mockHighScoreService, times(2)).getTopFivePlayers();
	}
}
