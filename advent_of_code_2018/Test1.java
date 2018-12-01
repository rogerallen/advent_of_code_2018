package advent_of_code_2018;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class Test1 {

	@Test
	void test1() {
		assertEquals(Day1.solve1(new int[] {+1, +1, +1}), 3);
		assertEquals(Day1.solve1(new int[] {+1, +1, -2}), 0);
		assertEquals(Day1.solve1(new int[] {-1, -2, -3}), -6);
	}

	@Test
	void testPart1() throws IOException {
		int[] array = Files
				.lines(Paths.get("input/day1.txt"))
                .mapToInt(Integer::parseInt)
                .toArray();
		assertEquals(Day1.solve1(array), 433);
	}

	@Test
	void test2() {
		assertEquals(Day1.solve2(new int[] {+1, -1}), 0);
		assertEquals(Day1.solve2(new int[] {+3, +3, +4, -2, -4}), 10);
		assertEquals(Day1.solve2(new int[] {-6, +3, +8, +5, -6}), 5);
		assertEquals(Day1.solve2(new int[] {+7, +7, -2, -7, -4}), 14);
	}
	
	@Test
	void testPart2() throws IOException {
		int[] array = Files
				.lines(Paths.get("input/day1.txt"))
                .mapToInt(Integer::parseInt)
                .toArray();
		assertEquals(Day1.solve2(array), 256);
	}

}
