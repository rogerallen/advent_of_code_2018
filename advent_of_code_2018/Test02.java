package advent_of_code_2018;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Test02 {
	
	String INPUT_FILE = "input/day02.txt";

	@Test
	void test1() {
		// Easier way to construct IntStream?
		//assertEquals(Day02.solve1(Stream.of( +1, +1, +1).mapToInt(x -> Integer.valueOf(x))), 3);
		assertEquals(Day02.solve1(Stream.of(
				"abcdef", // contains no letters that appear exactly two or three times.
				"abcdef", // contains no letters that appear exactly two or three times.
				"bababc", // contains two a and three b, so it counts for both.
				"abbcde", // contains two b, but no letter appears exactly three times.
				"abcccd", // contains three c, but no letter appears exactly two times.	
				"aabcdd", // contains two a and two d, but it only counts once.
				"abcdee", // contains two e.
				"ababab")), // contains three a and three b, but it only counts once.
				12); // 4*3 = 12
	}
	
	@Test
	void testPart1() throws IOException {
		assertEquals(Day02.solve1(Utils.fileToStringStream(INPUT_FILE)), 7470);
	}

	@Test
	void test2() {
		// Easier way to construct IntStream?
		//assertEquals(Day02.solve1(Stream.of( +1, +1, +1).mapToInt(x -> Integer.valueOf(x))), 3);
		assertEquals(Day02.solve2(Stream.of(
				"abcde",
				"fghij", 
				"klmno", 
				"pqrst", 
				"fguij", 
				"axcye", 
				"wvxyz")),
				"fgij"); // 4*3 = 12
	}
	
	@Test
	void testPart2() throws IOException {
		assertEquals(Day02.solve2(Utils.fileToStringStream(INPUT_FILE)), "kqzxdenujwcstybmgvyiofrrd");
	}


}
