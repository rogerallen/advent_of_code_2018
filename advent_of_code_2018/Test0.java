package advent_of_code_2018;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Test0 {

	@Test
	void test1() {
		String r = Day0.HelloWorld();
		assertEquals(r,"Hello World");
	}
	
	@Test
	void test2() {
		String r = Day0.HelloName("Roger");
		assertEquals(r,"Hello Roger");
	}
}
