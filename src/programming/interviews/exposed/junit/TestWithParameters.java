package programming.interviews.exposed.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestWithParameters {

	private final int a;
	private final int b;
	private final int expectedAddition;
	private final int expectedSubstraction;
	private final int expectedMultiplication;
	private final int expectedDivision;
	
	public TestWithParameters(int a, int b, int expectedAddition, int expectedSubstraction, int expectedMultiplication,
			int expectedDivision) {
		this.a = a;
		this.b = b;
		this.expectedAddition = expectedAddition;
		this.expectedSubstraction = expectedSubstraction;
		this.expectedMultiplication = expectedMultiplication;
		this.expectedDivision = expectedDivision;
	}

	@Parameterized.Parameters
	public static List<Integer[]> parameters() {
		return new ArrayList<Integer[]>(3) {{
			add(new Integer[] {1, 2, 3, -1, 2, 0});
			add(new Integer[] {0, 1, 1, -1, 0, 0});
			add(new Integer[] {-11, 2, -9, -13, -22, -5});
		}};
	}

	@Test
	public void addNumbers() {
		assertEquals(expectedAddition, a + b);
	}

	@Test
	public void subtractNumbers() {
		assertEquals(expectedSubstraction, a - b);
	}

	@Test
	public void multiplyNumbers() {
		assertEquals(expectedMultiplication, a * b);
	}

	@Test
	public void divideNumbers() {
		assertEquals(expectedDivision, a / b);
	}

}
