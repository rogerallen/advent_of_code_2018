package advent_of_code_2018;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Test04 {

	String INPUT_FILE = "input/day04.txt";

	@Test
	void test1() throws IOException {
		assertEquals(Day04.solve1(Utils.fileToStringStream("input/day04_test1.txt")), 240);
	}
	
	@Test
	void testPart1() throws IOException {
		assertEquals(Day04.solve1(Utils.fileToStringStream(INPUT_FILE)), 87681);
	}

	@Test
	void test2() throws IOException {
		assertEquals(Day04.solve2(Utils.fileToStringStream("input/day04_test1.txt")), 4455);
	}
	
	@Test
	void testPart2() throws IOException {
		assertEquals(Day04.solve2(Utils.fileToStringStream(INPUT_FILE)), 136461);
	}


}
