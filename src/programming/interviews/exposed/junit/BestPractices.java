package programming.interviews.exposed.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BestPractices {

	@Test
	public void assertionWithMessage() {
		final List<Integer> numbers = new ArrayList<>();
		numbers.add(1);

		assertTrue("This list should be empty", numbers.isEmpty());
		
	}

	@Test
	public void assertionWithoutMessage() {
		final List<Integer> numbers = new ArrayList<>();
		numbers.add(1);

		assertTrue(numbers.isEmpty());
		
	}

	@Test(expected = NoSuchFileException.class)
	public void expectException() throws IOException {
		Files.size(Paths.get("/tmp/1111.txt"));
	}

}
