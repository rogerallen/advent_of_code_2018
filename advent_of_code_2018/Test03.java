package advent_of_code_2018;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Test03 {

	String INPUT_FILE = "input/day03.txt";

	@Test
	void test1() {
		assertEquals(Day03.solve1(Stream.of(
				"#1 @ 1,3: 4x4",
				"#2 @ 3,1: 4x4",
				"#3 @ 5,5: 2x2")), 4);
	}
	
	@Test
	void testPart1() throws IOException {
		assertEquals(Day03.solve1(Utils.fileToStringStream(INPUT_FILE)), 110827);
	}

	@Test
	void test2() {
		assertEquals(Day03.solve2(Stream.of(
				"#1 @ 1,3: 4x4",
				"#2 @ 3,1: 4x4",
				"#3 @ 5,5: 2x2")), 3);
	}
	
	@Test
	void testPart2() throws IOException {
		assertEquals(Day03.solve2(Utils.fileToStringStream(INPUT_FILE)), 116);
	}

}
