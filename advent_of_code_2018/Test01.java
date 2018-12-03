package advent_of_code_2018;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
//import java.util.stream.IntStream;
import java.util.stream.Stream;

class Test01 {

	String INPUT_FILE = "input/day01.txt";
	
	@Test
	void test1() {
		// Easier way to construct IntStream?
		assertEquals(Day01.solve1(Stream.of( +1, +1, +1).mapToInt(x -> Integer.valueOf(x))), 3);
		assertEquals(Day01.solve1(Stream.of( +1, +1, -2).mapToInt(x -> Integer.valueOf(x))), 0);
		assertEquals(Day01.solve1(Stream.of( -1, -2, -3).mapToInt(x -> Integer.valueOf(x))), -6);
	}

	@Test
	void testPart1() throws IOException {
		assertEquals(Day01.solve1(Utils.fileToIntStream(INPUT_FILE)), 433);
	}


	@Test
	void test2() {
		assertEquals(Day01.solve2(Stream.of( +1, -1 ).mapToInt(x -> Integer.valueOf(x))), 0);
		assertEquals(Day01.solve2(Stream.of( +3, +3, +4, -2, -4 ).mapToInt(x -> Integer.valueOf(x))), 10);
		assertEquals(Day01.solve2(Stream.of( -6, +3, +8, +5, -6 ).mapToInt(x -> Integer.valueOf(x))), 5);
		assertEquals(Day01.solve2(Stream.of( +7, +7, -2, -7, -4 ).mapToInt(x -> Integer.valueOf(x))), 14);
	}

	
	@Test
	void testPart2() throws IOException {
		assertEquals(Day01.solve2(Utils.fileToIntStream(INPUT_FILE)), 256);
	}
	
}
