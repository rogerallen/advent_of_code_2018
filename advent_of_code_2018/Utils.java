package advent_of_code_2018;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {

	public static IntStream fileToIntStream(String filename) throws IOException {
		// removed .toArray();
		return Files.lines(Paths.get(filename)).mapToInt(x -> Integer.parseInt(x));
	}
	
	public static Stream<String> fileToStringStream(String filename) throws IOException {
		return Files.lines(Paths.get(filename));
	}	

}
