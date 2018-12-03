package advent_of_code_2018;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Day01 {

	// sum up values in inputs
	public static int solve1(IntStream inputStream) {
		return inputStream.sum();
	}

	// sum up values in inputs, but track sums along the way
	// when sum has been reached before, return that sum
	public static int solve2(IntStream inputStream) {
		int [] inputs = inputStream.toArray();
		Set<Integer> frequencies = new HashSet<Integer>();
		int sum = 0;
		frequencies.add(0);
		
		boolean go = true;
		while (go) {
			for (int i = 0; i < inputs.length; i++) {
				sum += inputs[i];
				//System.out.println(sum);
				if(frequencies.contains(sum)) {
					go = false;
					break;
				} else {
					frequencies.add(sum);
				}
			}
		}
		return sum;
	}
}
